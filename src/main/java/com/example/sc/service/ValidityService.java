package com.example.sc.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.sc.dto.ProviderRequest;
import com.example.sc.dto.ProviderResponse;
import com.example.sc.dto.SourceValidity;
import com.example.sc.dto.ValidityRequest;
import com.example.sc.dto.ValidityResponse;
import com.example.sc.service.ApplicationProps.Provider;

@Service
public class ValidityService {

	@Autowired
	private ApplicationProps appProps;

	private RestTemplate restTemplate = new RestTemplate();

	public ValidityResponse checkValidity(final ValidityRequest validityRequest) {
		// prepare provider-urls
		Map<String, String> sourceUrls = appProps.getProviders().stream()
				.filter(provider -> (validityRequest.getSources() == null || validityRequest.getSources().isEmpty()
						? true
						: validityRequest.getSources().contains(provider.getName())))
				.collect(Collectors.toMap(Provider::getName, Provider::getUrl));

		// send requests to providers
		Map<String, CompletableFuture<ProviderResponse>> resultMap = new HashMap<>();
		sourceUrls.keySet().forEach(source -> {
			resultMap.put(source, CompletableFuture.supplyAsync(() -> restTemplate.postForObject(sourceUrls.get(source),
					new ProviderRequest(validityRequest.getAccountNumber()), ProviderResponse.class)));
		});

		// collects responses and return
		ValidityResponse response = new ValidityResponse();
		sourceUrls.keySet().forEach(source -> {
			try {
				response.getResult().add(new SourceValidity(source, resultMap.get(source).get().isValid()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return response;
	}

}
