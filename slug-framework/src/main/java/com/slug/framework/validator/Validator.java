package com.slug.framework.validator;

/**
 * Defines the implementation of validation classes.
 * Instances of this class will utilized by <code>AbstractService</code> Class
 * 
 * @author Michael Rios
 *
 * @param <T>
 */
public interface Validator<T> {
	
	/**
	 * Do validation process if the supplied object parameter is valid for processing.
	 * @param object
	 * @return <code>boolean</code> TRUE if data is valid otherwise FALSE.
	 */
	public boolean validate(T object);
	
	
	/**
	 * Error Identifier.
	 * @return <code>String</code> that identifies error.
	 */
	public String getErrorId();
	
	
	/**
	 * Error Description
	 * @return <code>String</code> that describes the validation error. 
	 */
	public String getErrorDescription();
	
	
	/**
	 * Defines the severity of error e.g. INFO, WARNING, CRITICAL
	 * @return <code>String</code> 
	 */
	public String getErrorLevel();
	
}
