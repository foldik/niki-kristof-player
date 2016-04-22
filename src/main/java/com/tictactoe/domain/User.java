package com.tictactoe.domain;

public class User {

	private String uuid;
	private String type;

	public User(String uuid, String type) {
		this.uuid = uuid;
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}

	public String getType() {
		return type;
	}

}
