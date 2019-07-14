package com.app.org.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		Map<Object, Object> map = new TreeMap<>();
		map.put("ff", null);
		map.put("hi", null);
		map.put("hj", "hi");

		for (Map.Entry<Object, Object> data : map.entrySet()) {
			System.out.println(data.getKey() + "---" + data.getValue());
		}

		List<Student> st = new ArrayList<>();
		List<Student> st2 = new ArrayList<>();

		st.add(new App().new Student("Amit", "Morta"));
		st.add(new App().new Student("Abhi", "Morta"));
		st2.add(new App().new Student("Rk", "Morta"));
		System.out.println(st.toString());
	Map<String, Object> data=	Stream.of(st,st2).flatMap(it->it.stream()).collect(Collectors.toMap(Student::getName,(a)->a,(a,b)->a));
	System.out.println(data.toString());
	
	}

	class Student {
		private String name;
		private String address;

		public Student(String name, String address) {
			super();
			this.name = name;
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", address=" + address + "]";
		}

	}
}
