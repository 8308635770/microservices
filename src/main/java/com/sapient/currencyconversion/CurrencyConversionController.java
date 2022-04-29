package com.sapient.currencyconversion;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.currencyconversion.bean.CurrencyConversionValue;
import com.sapient.currencyconversion.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	 private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionValue calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		HashMap<String, String>uriVariables=new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionValue> responseEntity = new RestTemplate()
				.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionValue.class,
				uriVariables);
		
		CurrencyConversionValue currencyConversionValue=responseEntity.getBody();
		
		
		
		return new CurrencyConversionValue(
				currencyConversionValue.getId(),
				from,
				to,
				quantity,
				currencyConversionValue.getConvertionMultiple(),
				quantity.multiply(currencyConversionValue.getConvertionMultiple()),
				currencyConversionValue.getEnviroment()+" rest template");
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionValue calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		
		CurrencyConversionValue currencyConversionValue=currencyExchangeProxy.retriveExchangeValue(from, to);
		
		return new CurrencyConversionValue(
				currencyConversionValue.getId(),
				from,
				to,
				quantity,
				currencyConversionValue.getConvertionMultiple(),
				quantity.multiply(currencyConversionValue.getConvertionMultiple()),
				currencyConversionValue.getEnviroment()+" feign");
	}

}
