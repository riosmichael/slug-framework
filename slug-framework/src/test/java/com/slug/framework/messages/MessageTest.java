package com.slug.framework.messages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class MessageTest {

	private Message testClass;
	
	
	@Test
	public void testErrorLevels() {
		
		String id = "DTA-ERR-001";
		String description = "Error Description";
		
		
		testClass = new Message(id, description, Message.ErrorMessageLevel.ERROR.value());
		assertEquals(Message.ErrorMessageLevel.ERROR.value(), testClass.getLevel());	
		
		testClass = new Message(id, description, Message.ErrorMessageLevel.INFO.value());
		assertEquals(Message.ErrorMessageLevel.INFO.value(), testClass.getLevel());
		
		testClass = new Message(id, description, Message.ErrorMessageLevel.WARN.value());
		assertEquals(Message.ErrorMessageLevel.WARN.value(), testClass.getLevel());
		
		/** Check default values*/
	}
	
	
	/**
	 * This is to test the default values of the class after construction.
	 * <br>
	 * The Complete String property must contain the following values
	 * <br>(NOTE : String format will not be checked.)
	 * <ul>
	 * 	<li>id
	 * 	<li>description
	 * 	<li>level
	 * </ul>
	 */
	@Test
	public void testDefaultValues() {
		String id = "DTA-ERR-001";
		String description = "Error Description";
		
		testClass = new Message(id, description, Message.ErrorMessageLevel.ERROR.value());
		assertEquals(Message.ErrorMessageLevel.ERROR.value(), testClass.getLevel());	
		assertEquals(id, testClass.getId());
		assertEquals(description, testClass.getDescription());
		assertNotEquals(null, testClass.getTimeStamp());
		
		
		String completeString = testClass.getCompleteString();
		assertEquals(true, completeString.contains(id));
		assertEquals(true, completeString.contains(description));
		assertEquals(true, completeString.contains(Message.ErrorMessageLevel.ERROR.value()));
	}
	
	
	/**
	 * Tests for enum values of ErrorMessageLevel
	 */
	@Test
	public void testEnumValues() {
		assertEquals("INFORMATION", Message.ErrorMessageLevel.INFO.value());
		assertEquals("WARNING", Message.ErrorMessageLevel.WARN.value());
		assertEquals("ERROR", Message.ErrorMessageLevel.ERROR.value());
	}
	
	
	@Test
	public void testGetterSetters() {
		
		String id = "DTA-ERR-001";
		String description = "Error Description";
		String level = Message.ErrorMessageLevel.INFO.value();
		LocalDateTime timeStamp = LocalDateTime.now();
		
		
		testClass = new Message("", "", "");
		testClass.setId(id);
		testClass.setDescription(description);
		testClass.setLevel(level);
		testClass.setTimeStamp(timeStamp);
		
		assertEquals(id, testClass.getId());
		assertEquals(description, testClass.getDescription());
		assertEquals(Message.ErrorMessageLevel.INFO.value(), testClass.getLevel());
		assertEquals(timeStamp, testClass.getTimeStamp());
		
	}
}
