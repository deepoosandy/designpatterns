package com.designpattern.creational;

public class UserBuilderClient {
	public static void main(String arg[]) {
		User user = new User.Builder().address("ABC").age(19).name("user").build();
		System.out.println("Name: " + user.getName() + ", Age: " + user.getAge() + ", Address: " + user.getAddress());
	}

}

class User {
	private String name;
	private int age;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static class Builder {
		private String name;
		private int age;
		private String address;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		// return fully build object
		public User build() {
			return new User(this);
		}

	}

	// private constructor to enforce object creation through builder
	private User(Builder builder) {
		this.address = builder.address;
		this.age = builder.age;
		this.name = builder.name;
	}

}