package com.example.sc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderResponse {

	private boolean isValid;

	public ProviderResponse() {
		super();
	}

	public ProviderResponse(boolean isValid) {
		super();
		this.isValid = isValid;
	}

	@JsonProperty("isValid")
	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
