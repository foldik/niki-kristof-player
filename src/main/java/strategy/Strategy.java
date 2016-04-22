package strategy;

import java.util.List;

import com.tictactoe.domain.Coordinate;
import com.tictactoe.domain.Element;

public interface Strategy {

	Coordinate nextMove(List<Element> elements);
}
