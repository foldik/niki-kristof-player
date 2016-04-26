package com.tictactoe.dummystrategy.model;

import java.util.List;

import com.tictactoe.domain.Element;

public class Board {

	private List<LineHolder> lineHolders;

	public Board(List<LineHolder> lineHolders) {
		this.lineHolders = lineHolders;
	}

	public void add(Element element) {
		for (LineHolder lineHolder : lineHolders) {
			lineHolder.add(element);
		}
	}

}
