package com.tictactoe.dummystrategy.model.lineid;

import com.tictactoe.domain.Element;

public class RowIdGenerator implements LineIdGenerator {

	@Override
	public int generateId(Element element) {
		return element.getY();
	}

}
