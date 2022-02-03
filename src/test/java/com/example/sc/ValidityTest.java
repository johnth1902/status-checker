package com.example.sc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.sc.dto.ProviderRequest;
import com.example.sc.dto.ProviderResponse;
import com.example.sc.dto.ValidityRequest;
import com.example.sc.dto.ValidityResponse;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ValidityTest {
	private static final String providerUrl = "http://localhost:8080/provider/source1/account/validate";
	private static final String validityUrl = "http://localhost:8080/validity/check";
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testProviderEndpoint() throws Exception {
		ProviderResponse response = restTemplate.postForObject(providerUrl, new ProviderRequest("1234"),
				ProviderResponse.class);
		assertEquals(true, response.isValid());
	}

	@Test
	public void testValidityEndpoint() throws Exception {
		ValidityResponse response1 = restTemplate.postForObject(validityUrl, new ValidityRequest("1234", null),
				ValidityResponse.class);
		assertEquals(4, response1.getResult().size());
		ValidityResponse response2 = restTemplate.postForObject(validityUrl,
				new ValidityRequest("1234", Set.of("source3", "source4")), ValidityResponse.class);
		assertEquals(2, response2.getResult().size());
		ValidityResponse response3 = restTemplate.postForObject(validityUrl,
				new ValidityRequest("1234", Set.of("source1")), ValidityResponse.class);
		assertEquals(true, response3.getResult().get(0).isValid());
	}
}
