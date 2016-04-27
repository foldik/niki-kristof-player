package strategy;

import java.util.List;

import com.tictactoe.domain.Coordinate;
import com.tictactoe.domain.Element;

public class TicTacToeStrategy implements Strategy{
	
	private Minimax minimax;
	private Board board;
	private String myType;
	
	private static final int depth = 3;
	
	public TicTacToeStrategy(String myType) {
		this.myType = myType;
		minimax = new Minimax();
	}
	
	@Override
	public Coordinate nextMove(List<Element> elements) {
		createBoard(elements);
		Object[] next = minimax.miniMaxWithAlphaBetaPruning(board, 1, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		return (Coordinate) next[1];
	}
	
	public Coordinate firstMove() {
		return new Coordinate(0,0);
	}
	
	private void createBoard(List<Element> elements) {
		int minX = elements.get(0).getX();
		int maxX = elements.get(0).getX();
		int minY = elements.get(0).getY();
		int maxY = elements.get(0).getY();
		
		for (Element e: elements) {
			if (e.getX() < minX) minX = e.getX();
			if (e.getX() > maxX) maxX = e.getX();
			if (e.getY() < minY) minY = e.getY();
			if (e.getY() > maxY) maxY = e.getY();
		}
		
		int width = maxX - minX;
		int height = maxY - minY;
		
		board = new Board(((width > height) ? width : height)+5, minX, minY);
		
	}

}
