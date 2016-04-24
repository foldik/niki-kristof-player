package com.tictactoe.http.domain.request;

public class IsMyTurnRequest {

	private String uuid;

	public IsMyTurnRequest(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		return "IsMyTurnRequest [uuid=" + uuid + "]";
	}

}
