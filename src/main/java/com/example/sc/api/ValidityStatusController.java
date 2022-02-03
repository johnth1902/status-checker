package com.example.sc.api;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sc.dto.ValidityRequest;
import com.example.sc.dto.ValidityResponse;
import com.example.sc.service.ValidityService;

@RestController("validityStatusController")
@RequestMapping("/validity")
public class ValidityStatusController {
	Logger logger = LoggerFactory.getLogger(ValidityStatusController.class);

	private ValidityService validityService;

	public ValidityStatusController(ValidityService validityService) {
		this.validityService = validityService;
	}

	@PostMapping("/check")
	ValidityResponse checkValidity(@RequestBody final ValidityRequest validityRequest) {
		logger.info("checkValidity invoked with {}", validityRequest);
		Instant start = Instant.now();
		ValidityResponse response = validityService.checkValidity(validityRequest);
		logger.info("checkValidity completed with {} in {} seconds", response,
				Duration.between(start, Instant.now()).getSeconds());
		return response;
	}

}
