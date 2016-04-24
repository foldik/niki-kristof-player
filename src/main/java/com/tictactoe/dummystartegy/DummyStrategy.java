package com.tictactoe.dummystartegy;

import java.util.List;

import com.tictactoe.domain.Coordinate;
import com.tictactoe.domain.Element;

import strategy.Strategy;

public class DummyStrategy implements Strategy {

	@Override
	public Coordinate nextMove(List<Element> elements) {
		return new Coordinate((int) (Math.random() * 20), (int) (Math.random() * 20));
	}

}
