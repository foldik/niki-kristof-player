package com.tictactoe.dummystrategy.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.tictactoe.domain.Coordinate;
import com.tictactoe.domain.Element;
import com.tictactoe.dummystrategy.model.Line;

public class RowEvaluator implements LineEvaluator {

	@Override
	public List<Coordinate> evaluate(Line line, String type) {
		List<Coordinate> winningMoves = new ArrayList<>();
		
		for (Element e: line.getElements()) {
			
		}
		
		return winningMoves;
	}

}
