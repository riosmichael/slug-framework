package com.slug.framework.messages;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Message {
	
	private String id;
	private String description;
	private String level;
	private LocalDateTime timeStamp;
	
	
	public enum ErrorMessageLevel{
		INFO("INFORMATION"),
		WARN("WARNING"),
		ERROR("ERROR");
		
		private final String level;
		
		ErrorMessageLevel(String level) {
			this.level = level;
		}
		
		public String value() {
			return level;
		}
	}
	
	
	public Message(String id, String description, String level){
		this.setId(id);
		this.setDescription(description);
		this.setLevel(level);
		this.timeStamp = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@JsonIgnore
	public String getCompleteString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[").append(level).append("]");
		stringBuilder.append(" ").append(id).append(" :");
		stringBuilder.append(" ").append(description);
		
		return stringBuilder.toString();
	}


}
