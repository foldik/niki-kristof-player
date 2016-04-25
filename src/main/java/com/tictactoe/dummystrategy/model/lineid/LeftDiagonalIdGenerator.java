package com.tictactoe.dummystrategy.model.lineid;

import com.tictactoe.domain.Element;

public class LeftDiagonalIdGenerator implements LineIdGenerator {

	@Override
	public int generateId(Element element) {
		return element.getX() + element.getY();
	}

}
