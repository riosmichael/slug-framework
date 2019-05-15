package com.slug.framework.validator;

public class StringValidator {

	private String value;
	
	public StringValidator(String value) {
		this.value = value;
	}
	
	
	public boolean isNotNull() {
		return this.value != null;
	}
	
	public boolean isNotEmpty() {
		return this.value != null && !this.value.trim().isEmpty();
	}
	
	public boolean isNotMoreThan(int length) {
		return this.value != null && this.value.length() <= length;
	}
	
	
	
	public boolean isNotNull(String value) {
		return value != null;
	}
	
	public boolean isNotEmpty(String value) {
		return value != null && !value.isEmpty();
	}
	
	public boolean isNotMoreThan(String value, int length) {
		return value != null && value.length() <= length;
	}
}
