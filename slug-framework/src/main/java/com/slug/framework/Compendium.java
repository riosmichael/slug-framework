package com.slug.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will contain the collection/list of POJO created by each processor.
 * Those objects are expected to be referenced by Processors.
 * 
 * @author Michael Rios
 *
 */
public class Compendium<R extends ServiceResponse<?>> {

	/**
	 * Storage of objects created by Processors. 
	 * This is the way to share the objects between the processors.
	 */
	private Map<String, Object> objects;
	
	
	/**
	 * Data Structure of the service response. This object will be utilized by the service controllers.
	 */
	private ServiceResponse<?> serviceResponse;
	
	
	
	/** Default Constructor */
	public Compendium() {
		this.serviceResponse = new ServiceResponse<>();
		this.objects = new HashMap<String, Object>();
	}

	
	public ServiceResponse<?> getServiceResponse() {
		return serviceResponse;
	}

	public void setServiceResponse(ServiceResponse<?> serviceResponse) {
		this.serviceResponse = serviceResponse;
	}


	public Map<String, Object> getObjects() {
		return objects;
	}

	/**
	 * Convenience method to add an {@code Object} to the collection.
	 * @param key
	 * @param value
	 */
	public void addObject(String key, Object value) {
		this.objects.put(key, value);
	}
	
}
