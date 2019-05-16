package com.slug.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.slug.framework.messages.CoreMessages;
import com.slug.framework.messages.Message;
import com.slug.framework.utilities.ExceptionLogger;
import com.slug.framework.validator.AbstractValidator;
import com.slug.framework.validator.Validator;

/**
 * Handles the design pattern of classes annotated with @Service <br>
 * Service classes must extended this class to maintain the uniformity of code
 * implementation and design patterns.
 * 
 * @author Michael Rios
 *
 * @param <T>
 * @param <V>
 */
public abstract class AbstractService<T, R extends ServiceResponse<?>> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractService.class);
	
	
	/**
	 * @param model
	 * @return {@code ServiceResponse<V>}
	 */
	@SuppressWarnings("unchecked")
	public R execute(T model) {
		
		Compendium<R> compendium = new Compendium<>();
		List<Message> errorMessages = validateModel(model, compendium.getServiceResponse());
		
		
		/** Pre-Validation */
		if(hasValidationError(errorMessages)) {
			compendium.getServiceResponse().setMessages(errorMessages);
			compendium.getServiceResponse().setStatus(HttpStatus.BAD_REQUEST);
			return (R) compendium.getServiceResponse();
		}
		
		/** Execute Processors */
		executeProcessors(model, compendium);
				
		/** Post-Validation */
		if(hasValidationError(compendium.getServiceResponse().getMessages())) {
			compendium.getServiceResponse().setStatus(HttpStatus.BAD_REQUEST);
			return (R) compendium.getServiceResponse();
		}
		
		
		/** Return response */
		compendium.getServiceResponse().setStatus(HttpStatus.OK);
		return (R) compendium.getServiceResponse();
		
	}

	
	
	protected void executeProcessors(T model, Compendium<R> compendium) {
		List<Processor<T, R>> listOfProcessors = new ArrayList<>();
		initProcessors(listOfProcessors);

		if (listOfProcessors.isEmpty()) {
			compendium.getServiceResponse().getMessages().add(CoreMessages.get("FRW-WRN-001"));
			logger.warn(CoreMessages.get("FRW-WRN-001").getCompleteString());
			return;
		}

		
		try {
			for (Processor<T, R> processor : listOfProcessors) {
				processor.execute(model, compendium);
			}
			
		} catch (Exception e) {
			compendium.getServiceResponse().getMessages().add(CoreMessages.get("APP-ERR-001"));
			ExceptionLogger.logException(logger, "executeProcessor", e);
		}
	}

	
	
	/**
	 * Validates the object based on a provided list of validator objects.
	 * 
	 * @param object
	 * @return <code>boolean</code> TRUE if validation error was encountered
	 *         otherwise FALSE
	 */
	protected List<Message> validateModel(T model, ServiceResponse<?> serviceResponse) {
		List<AbstractValidator<T>> validators = new ArrayList<>();
		List<Message> errorMessages = new ArrayList<>();
		
		initValidators(validators);
		
		if (validators.isEmpty()) {
			serviceResponse.getMessages().add(CoreMessages.get("FRW-WRN-002"));
			logger.warn(CoreMessages.get("FRW-WRN-002").getCompleteString());
			return Collections.emptyList();
		}

		for (Validator<T> validator : validators) {
			if (!validator.validate(model)) {
				errorMessages.add(new Message(validator.getErrorId(), validator.getErrorDescription(),
						validator.getErrorLevel()));
			}
		}

		return errorMessages;
	}

	
	/**
	 * 
	 * @param listOfMessages
	 * @return {@code true} - if list contains a message with level of {@code ERROR}.
	 */
	protected boolean hasValidationError(final List<Message> listOfMessages){
		return listOfMessages.stream()
				.anyMatch(o -> o.getLevel().equals(Message.ErrorMessageLevel.ERROR.value()));
	}
	
	

	protected abstract void initValidators(List<AbstractValidator<T>> validators);

	protected abstract void initProcessors(List<Processor<T, R>> processors);

}
