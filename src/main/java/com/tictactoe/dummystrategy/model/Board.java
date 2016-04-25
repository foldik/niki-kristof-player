package com.tictactoe.dummystrategy.model;

import com.tictactoe.domain.Element;
import com.tictactoe.dummystrategy.model.lineid.ColumnIdGenerator;
import com.tictactoe.dummystrategy.model.lineid.LeftDiagonalIdGenerator;
import com.tictactoe.dummystrategy.model.lineid.RightDiagonalIdGenerator;
import com.tictactoe.dummystrategy.model.lineid.RowIdGenerator;

public class Board {
	
	private LineHolder rowHolder = new LineHolder(new RowIdGenerator());
	private LineHolder columnHolder = new LineHolder(new ColumnIdGenerator());
	private LineHolder rightDiagonalHolder = new LineHolder(new RightDiagonalIdGenerator());
	private LineHolder leftDiagonalHolder = new LineHolder(new LeftDiagonalIdGenerator());
	
	public void add(Element element) {
		rowHolder.add(element);
		columnHolder.add(element);
		rightDiagonalHolder.add(element);
		leftDiagonalHolder.add(element);
	}

}
