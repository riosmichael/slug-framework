package com.slug.framework.validator;

/**
 * Abstract implementation of {@code Validator} interface.
 * 
 * @author Michael Rios
 * @param <T>
 */
public abstract class AbstractValidator<T> implements Validator<T>{

	protected String errorId; 
	protected String errorDescription;
	protected String errorLevel;
	
	
	public boolean validate(T object) {
		/** return default */
		return true;
	}

	
	public String getErrorId() {
		return errorId;
	}

	
	public String getErrorDescription() {
		return errorDescription;
	}

	
	public String getErrorLevel() {
		return errorLevel;
	}

}
