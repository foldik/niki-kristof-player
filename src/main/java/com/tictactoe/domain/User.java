package com.tictactoe.domain;

import com.google.gson.annotations.SerializedName;

public class User {

	private String uuid;
	private String type;
	@SerializedName("gid")
	private String gameId;

	public User(String uuid, String type, String gameId) {
		this.uuid = uuid;
		this.type = type;
		this.gameId = gameId;
	}

	public String getUuid() {
		return uuid;
	}

	public String getType() {
		return type;
	}

	public String getGid() {
		return gameId;
	}

	@Override
	public String toString() {
		return "User [userId=" + uuid + ", type=" + type + ", gameId=" + gameId + "]";
	}
	
	

}
