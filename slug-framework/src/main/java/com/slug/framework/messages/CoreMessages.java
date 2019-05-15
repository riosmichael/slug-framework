package com.slug.framework.messages;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains the standard error messages for the CORE FRAMEWORK.
 * 
 * @author Michael Rios
 *
 */
public class CoreMessages {

	public static final Map<String, Message> messagesMap;
	
	static {
		messagesMap = new HashMap<>();
		
		messagesMap.put("FRW-WRN-001", 
				new Message("FRW-WRN-001",
						"No business processor was defined for this service.", 
						Message.ErrorMessageLevel.WARN.value()));
		
		
		messagesMap.put("FRW-WRN-002", 
				new Message("FRW-WRN-002",
						"No business validator was defined for this service. Validation result will be defaulted to TRUE "
						+ "means data is valid for processing.", 
						Message.ErrorMessageLevel.WARN.value()));
		
		
		messagesMap.put("APP-ERR-001", 
				new Message("APP-ERR-001",
						"Caught application error, contact your system administrator.", 
						Message.ErrorMessageLevel.ERROR.value()));
	}
	
	
	
}
