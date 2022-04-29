package com.sapient.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.limitsservice.bean.Limits;
import com.sapient.limitsservice.configration.Configration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configration configration;
	
	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(configration.getMinimum(),configration.getMaximum());
		
	}

}
