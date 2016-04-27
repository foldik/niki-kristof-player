package com.tictactoe.http.domain.response;

import com.tictactoe.domain.Element;

public class IsMyTurnResponse {

	private int statusCode;
	private String message;
	private boolean isMyTurn;
	private Element lastMove;

	public IsMyTurnResponse(int statusCode, String message, boolean isMyTurn, Element lastMove) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.isMyTurn = isMyTurn;
		this.lastMove = lastMove;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public boolean isMyTurn() {
		return isMyTurn;
	}

	public Element getLastMove() {
		return lastMove;
	}

	@Override
	public String toString() {
		return "IsMyTurnResponse [statusCode=" + statusCode + ", message=" + message + ", isMyTurn=" + isMyTurn
				+ ", lastMove=" + lastMove + "]";
	}

}
