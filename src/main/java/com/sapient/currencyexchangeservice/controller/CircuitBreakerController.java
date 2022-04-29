package com.sapient.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name = "sample-api",fallbackMethod = "hardcodedResponse")
//	@CircuitBreaker(name = "default",fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name = "default")
	public String sampleApi() {
		
		logger.info("Sample api called..");
//		new RestTemplate().getForEntity("localhost:8000/xyz", String.class);
		return "Sample API";
	}
	
	private String hardcodedResponse(Exception ex) {
		System.out.println("fallback method is called...");
		return "FallbackResponse";
		
	}

}
