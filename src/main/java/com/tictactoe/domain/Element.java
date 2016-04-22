package com.tictactoe.domain;

import com.google.gson.annotations.SerializedName;

public class Element {

	private int x;
	
	private int y;
	
	@SerializedName("t")
	private String type;

	public Element(int x, int y, String type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getType() {
		return type;
	}

}
