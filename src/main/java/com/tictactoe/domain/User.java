package com.tictactoe.domain;

import com.google.gson.annotations.SerializedName;

public class User {

	private String name;
	private String uuid;
	private String type;
	private String gameId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", uuid=" + uuid + ", type=" + type + ", gameId=" + gameId + "]";
	}

}
