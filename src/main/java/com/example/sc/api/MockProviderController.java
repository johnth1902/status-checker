package com.example.sc.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sc.dto.ProviderRequest;
import com.example.sc.dto.ProviderResponse;

@RestController
@RequestMapping("/provider")
public class MockProviderController {

	@PostMapping("source1/account/validate")
	ProviderResponse source1(@RequestBody final ProviderRequest request) {
		delay();
		return new ProviderResponse(true);
	}

	@PostMapping("source2/account/validate")
	ProviderResponse source2(@RequestBody final ProviderRequest request) {
		delay();
		return new ProviderResponse(false);
	}

	@PostMapping("source3/account/validate")
	ProviderResponse source3(@RequestBody final ProviderRequest request) {
		delay();
		return new ProviderResponse(true);
	}

	@PostMapping("source4/account/validate")
	ProviderResponse source4(@RequestBody final ProviderRequest request) {
		delay();
		return new ProviderResponse(false);
	}

	private void delay() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
