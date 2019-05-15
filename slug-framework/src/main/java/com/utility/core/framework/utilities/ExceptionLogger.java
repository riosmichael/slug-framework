package com.utility.core.framework.utilities;

import org.slf4j.Logger;

public class ExceptionLogger {

	/** private default constructor to avoid initialization */
	private ExceptionLogger() {
	}
	
	
	/**
	 * Purpose is to have control on logging process. For example you want to call a service
	 * that will collect the error or do email notification once exception is caught.
	 *  
	 * @param logger - {@code org.slf4j.Logger}
	 * @param methodName - {@code String}
	 * @param e - {@code Throwable}
	 */
	public static void logException(Logger logger, String methodName, Throwable e) {
		
		logger.error("Caught Exception on method : " + methodName + " " + e.getCause());
	}
	
}
