package com.app.org.clone;

public class Address implements Cloneable{

	private String country;
	private int pincode;
	private String state;
	
	
	
	public Address(String country, int pincode, String state) {
		super();
		this.country = country;
		this.pincode = pincode;
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	@Override
	public String toString() {
		return "Address [country=" + country + ", pincode=" + pincode + ", state=" + state + "]";
	}
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();

	}
	
	
	
}
