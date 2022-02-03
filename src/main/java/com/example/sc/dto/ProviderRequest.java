package com.example.sc.dto;

public class ProviderRequest {

	private String accountNumber;

	public ProviderRequest() {
		super();
	}

	public ProviderRequest(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
