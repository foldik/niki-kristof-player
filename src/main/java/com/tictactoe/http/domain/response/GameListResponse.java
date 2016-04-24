package com.tictactoe.http.domain.response;

import java.util.List;

public class GameListResponse {

	private List<Game> games;

	public GameListResponse(List<Game> games) {
		this.games = games;
	}

	public List<Game> getGames() {
		return games;
	}

	@Override
	public String toString() {
		return "GameListResponse [games=" + games + "]";
	}

}
