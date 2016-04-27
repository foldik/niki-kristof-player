package com.tictactoe.http.domain.request;

public class RegistrationRequest {

	private String name;

	public RegistrationRequest(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [name=" + name + "]";
	}

}
