package com.tictactoe.dummystrategy.model;

import com.tictactoe.domain.Element;

public class Board {

	private LineHolder rows;
	private LineHolder columns;
	private LineHolder rightDiagonals;
	private LineHolder leftDiagonals;

	public Board(LineHolder rows, LineHolder columns, LineHolder rightDiagonals, LineHolder leftDiagonals) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.rightDiagonals = rightDiagonals;
		this.leftDiagonals = leftDiagonals;
	}

	public void add(Element element) {
		rows.add(element);
		columns.add(element);
		rightDiagonals.add(element);
		leftDiagonals.add(element);
	}

}
