package com.example.sc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceValidity {
	private String source;
	private boolean isValid;

	public SourceValidity(String source, boolean isValid) {
		super();
		this.source = source;
		this.isValid = isValid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("isValid")
	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "SourceValidity [source=" + source + ", isValid=" + isValid + "]";
	}

}
