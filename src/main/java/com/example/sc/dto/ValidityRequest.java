package com.example.sc.dto;

import java.util.Set;

public class ValidityRequest {

	private String accountNumber;

	private Set<String> sources;

	public ValidityRequest() {
		super();
	}

	public ValidityRequest(String accountNumber, Set<String> sources) {
		super();
		this.accountNumber = accountNumber;
		this.sources = sources;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Set<String> getSources() {
		return sources;
	}

	public void setSources(Set<String> sources) {
		this.sources = sources;
	}

	@Override
	public String toString() {
		return "ValidityRequest [accountNumber=" + accountNumber + ", sources=" + sources + "]";
	}

}
