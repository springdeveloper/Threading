package com.app.org.clone;

public class ShallowClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Address address = new Address("India", 222161, "UP");
		User user = new User("Navneet", "a@gmail.com", address);
        user.getAddress().setCountry("jjj");

		User u2 = (User) user.clone();

		System.out.println(u2.toString());
		System.out.println(user.toString());

	}

}
