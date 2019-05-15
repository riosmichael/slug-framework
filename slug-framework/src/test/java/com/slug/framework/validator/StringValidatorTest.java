package com.slug.framework.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringValidatorTest {

	private final static Logger logger = LoggerFactory.getLogger(StringValidatorTest.class);
	private StringValidator testClass;
	
	
	@Test
	public void testIsNotNull() {
		logger.info("Testing method : isNotNull()");
		
		testClass = new StringValidator(null);
		assertEquals(false, testClass.isNotNull());
		
		testClass = new StringValidator("test");
		assertEquals(true, testClass.isNotNull());
		
		logger.info("Testing method : isNotNull() : Passed");
		
	}
	
	@Test
	public void testIsNotEmpty() {
		logger.info("Testing method : isNotEmpty()");
		
		testClass = new StringValidator(null);
		assertEquals(false, testClass.isNotEmpty());
		
		testClass = new StringValidator("");
		assertEquals(false, testClass.isNotEmpty());
		
		testClass = new StringValidator("test");
		assertEquals(true, testClass.isNotEmpty());
		
		logger.info("Testing method : isNotEmpty() : Passed");
	}
	
	
	@Test
	public void testIsNotMoreThan() {
		logger.info("Testing method : isNotMoreThan()");
		
		testClass = new StringValidator("ABCD");
		assertEquals(true, testClass.isNotMoreThan(5));
		assertEquals(true, testClass.isNotMoreThan(4));
		assertEquals(false, testClass.isNotMoreThan(3));
		assertEquals(false, testClass.isNotMoreThan(2));
		
		testClass = new StringValidator(null);
		assertEquals(false, testClass.isNotMoreThan(5));
		
		logger.info("Testing method : isNotMoreThan() : Passed");
	}
	
	@Test
	public void testIsNotNullStringArg() {
		logger.info("Testing method : isNotNull(String)");
		
		testClass = new StringValidator(null);
		assertEquals(false, testClass.isNotNull(null));
		assertEquals(true, testClass.isNotNull(""));
		assertEquals(true, testClass.isNotNull("ABCD"));
		
		logger.info("Testing method : isNotNull(String) : Passed");
	}
	
	@Test
	public void testIsNotEmptyStringArg() {
		logger.info("Testing method : isNotEmpty(String)");
		
		testClass = new StringValidator(null);
		
		assertEquals(false, testClass.isNotEmpty(null));
		assertEquals(false, testClass.isNotEmpty(""));
		assertEquals(true, testClass.isNotEmpty(" "));
		assertEquals(true, testClass.isNotEmpty("ABCD"));
		
		logger.info("Testing method : isNotEmpty(String) : Passed");
	}
	
	@Test
	public void testIsNotMoreThanWithArgs() {
		logger.info("Testing method : isNotMoreThan(String, int)");
		
		testClass = new StringValidator(null);
		assertEquals(false, testClass.isNotMoreThan(null, 5));
		assertEquals(true, testClass.isNotMoreThan("", 5));
		assertEquals(true, testClass.isNotMoreThan(" ", 5));
		assertEquals(true, testClass.isNotMoreThan("     ", 5));
		assertEquals(false, testClass.isNotMoreThan("      ", 5));
		assertEquals(false, testClass.isNotMoreThan("ABCDEF", 5));
		assertEquals(true, testClass.isNotMoreThan("ABCDE", 5));
		assertEquals(true, testClass.isNotMoreThan("ABCD", 5));
		
		logger.info("Testing method : isNotMoreThan(String, int) : Passed");
	}
}
