package com.tictactoe.http.request;

public class PutRequest {

	private String uuid;
	private int x;
	private int y;

	public PutRequest(String uuid, int x, int y) {
		this.uuid = uuid;
		this.x = x;
		this.y = y;
	}

	public String getUuid() {
		return uuid;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
