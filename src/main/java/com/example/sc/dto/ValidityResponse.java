package com.example.sc.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidityResponse {

	private List<SourceValidity> result = new ArrayList<>();

	public List<SourceValidity> getResult() {
		return result;
	}

	public void setResult(List<SourceValidity> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ValidityResponse [result=" + result + "]";
	}

}