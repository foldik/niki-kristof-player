package com.tictactoe.http.domain.response;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {

	private String statusCode;
	private String message;
	private String uuid;
	private String type;
	@SerializedName("gid")
	private String gameId;

	public RegistrationResponse(String statusCode, String message, String uuid, String type, String gameId) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.uuid = uuid;
		this.type = type;
		this.gameId = gameId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public String getUuid() {
		return uuid;
	}

	public String getType() {
		return type;
	}

	public String getGameId() {
		return gameId;
	}

	@Override
	public String toString() {
		return "RegistrationResponse [statusCode=" + statusCode + ", message=" + message + ", uuid=" + uuid + ", type="
				+ type + ", gameId=" + gameId + "]";
	}

}
