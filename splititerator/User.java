package com.uj.splititerator;

public class User {

	private Integer userId;
	private String name;
	private String address;

	public User() {

	}

	public User(Integer userId, String name, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

}
