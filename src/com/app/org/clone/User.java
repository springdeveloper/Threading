package com.app.org.clone;

public class User implements Cloneable {

	private String name;
	private String email;
	private Address address;

	public User(String name, String email, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", address=" + address + "]";
	}

	protected Object clone() throws CloneNotSupportedException {
          User u=(User)super.clone();
          u.address=(Address)address.clone();
		return u;

	}
}