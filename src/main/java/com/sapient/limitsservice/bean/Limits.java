package com.sapient.limitsservice.bean;

public class Limits {
	
	private int minimum;
	private int maximum;
	
	public Limits() {
		super();
	}
	public Limits(int minimux, int maximum) {
		super();
		this.minimum = minimux;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimux) {
		this.minimum = minimux;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
	

}
