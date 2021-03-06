package com.java.spring.core.autowire.xmlconfig;

public class Address {
	
	String city;
	String country;
	int pin;
	
	
	@Override
	public String toString() {
		return city +","+ country +","+ pin;
	}

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}

}
