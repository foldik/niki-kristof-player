package com.tictactoe.http.domain.response;

import com.google.gson.annotations.SerializedName;

public class Game {

	@SerializedName("gid")
	private String gameId;

	public Game(String gameId) {
		this.gameId = gameId;
	}

	public String getGameId() {
		return gameId;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + "]";
	}

}
