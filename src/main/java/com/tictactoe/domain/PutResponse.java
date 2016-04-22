package com.tictactoe.domain;

import com.google.gson.annotations.SerializedName;

public class PutResponse {

	@SerializedName("statuscode")
	private int statusCode;
	private String message;

	public PutResponse(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

}
