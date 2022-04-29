package com.sapient.currencyconversion.bean;

import java.math.BigDecimal;

public class CurrencyConversionValue {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal convertionMultiple;
	private BigDecimal quatity;
	private BigDecimal totalCalculatedCost;
	private String enviroment;
	
	public CurrencyConversionValue() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public CurrencyConversionValue(Long id, String from, String to, BigDecimal quatity, BigDecimal conversionMultiple,
			BigDecimal totalCalculatedCost, String env) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = conversionMultiple;
		this.quatity = quatity;
		this.totalCalculatedCost = totalCalculatedCost;
		this.enviroment = env;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	public BigDecimal getAmount() {
		return quatity;
	}

	public void setAmount(BigDecimal quatity) {
		this.quatity = quatity;
	}

	
	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}

	public void setConvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}

	public BigDecimal getTotalCalculatedCost() {
		return totalCalculatedCost;
	}

	public void setTotalCalculatedCost(BigDecimal totalCalculatedCost) {
		this.totalCalculatedCost = totalCalculatedCost;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnv(String env) {
		this.enviroment = env;
	}
	
	
	
	

}
