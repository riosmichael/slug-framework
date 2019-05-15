package com.slug.framework;


/**
 * Defines the implementation of business implementation classes.
 * Instances of this class will utilized by <code>AbstractService</code> Class
 * 
 * @author Michael Rios
 *
 * @param <M>
 * @param <T>
 */
public abstract class Processor<T, R extends ServiceResponse<?>> {

	
	public abstract void execute(T model, Compendium<R> compendium) throws Exception;
}
