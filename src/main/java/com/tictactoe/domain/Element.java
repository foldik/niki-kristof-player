package com.tictactoe.domain;

public class Element {

	private final Coordinate coordinate;
	private final String type;

	public Element(Coordinate coordinate, String type) {
		this.coordinate = coordinate;
		this.type = type;
	}

	public int getX() {
		return coordinate.getX();
	}

	public int getY() {
		return coordinate.getY();
	}

	public String getType() {
		return type;
	}

}
