package com.tictactoe.domain;

public class IsMyTurnRequest {

	private String uuid;

	public IsMyTurnRequest(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

}
