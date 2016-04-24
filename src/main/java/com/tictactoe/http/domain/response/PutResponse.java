package com.tictactoe.http.domain.response;

public class PutResponse {

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

	@Override
	public String toString() {
		return "PutResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}

}
