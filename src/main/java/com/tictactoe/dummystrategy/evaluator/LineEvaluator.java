package com.tictactoe.dummystrategy.evaluator;

import java.util.List;

import com.tictactoe.domain.Coordinate;
import com.tictactoe.dummystrategy.model.Line;

public interface LineEvaluator {
	
	public List<Coordinate> evaluate(Line line, String type);

}
