package com.slug.framework.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.slug.framework.messages.Message;

public class AbstractValidatorTest {
	
	
	/**
	 * Inner class is used to test the Abstract class {@code AbstractValidator}
	 */
	class ValidatorTestImpl extends AbstractValidator<String>{
		
		private final String errorId = "DTA-ERR-001";
		private final String errorDescription = "Error Description";
		private final String errorLevel = Message.ErrorMessageLevel.ERROR.value();
			
		
		public ValidatorTestImpl() {
			super.errorId = this.errorId;
			super.errorDescription = this.errorDescription;
			super.errorLevel = this.errorLevel;
		}
	}
	
	/** Test Class instance of defined inner class {@class ValidatorTestImpl}*/
	private ValidatorTestImpl testClass = new ValidatorTestImpl();
	
	
	@Test
	public void testGetterMethods() {
		assertEquals("DTA-ERR-001", testClass.getErrorId());
		assertEquals("Error Description", testClass.getErrorDescription());
		assertEquals(Message.ErrorMessageLevel.ERROR.value(), testClass.getErrorLevel());
	}
	
	
	@Test
	public void testValidateMethod() {
		assertEquals(true, testClass.validate(""));
	}
}
