package com.tictactoe.http.response;

import com.tictactoe.domain.Element;

public class IsMyTurnResponse {

	private boolean isMyTurn;
	private Element lastMove;

	public IsMyTurnResponse(boolean isMyTurn, Element lastMove) {
		super();
		this.isMyTurn = isMyTurn;
		this.lastMove = lastMove;
	}

	public boolean isMyTurn() {
		return isMyTurn;
	}

	public Element getLastMove() {
		return lastMove;
	}

	@Override
	public String toString() {
		return "IsMyTurnResponse [isMyTurn=" + isMyTurn + ", lastMove=" + lastMove + "]";
	}

	
	
}
