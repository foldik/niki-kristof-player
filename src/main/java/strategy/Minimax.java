package strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.tictactoe.domain.Coordinate;

public class Minimax {
	
	double evaluate(Board board) {
		int oneAway = board.nearWins(board.prevPlayer, 1);
		int twoAway = board.nearWins(board.prevPlayer, 2);
		int threeAway = board.nearWins(board.prevPlayer, 3);
		double score = oneAway * 100.0 + twoAway * 5.0 + threeAway * 1.0;
		return score;
	}

	Object[] miniMaxWithAlphaBetaPruning(Board board, int d, double myBest, double theirBest) {
		ArrayList<Coordinate> moveList;
		Set<Coordinate> moves = new HashSet<Coordinate>();
		ArrayList<Coordinate> places = board.getPlayerPlaces(board.nextPlayer);
		for (int i = 0; i < places.size(); i++) {
			moves.addAll(board.lookAround(places.get(i)));
		}
		moves.retainAll(board.getEmpties());
		if (moves.isEmpty())
			moveList = new ArrayList<Coordinate>(board.getEmpties());
		else
			moveList = new ArrayList<Coordinate>(moves);

		Double bestScore;
		Object[] temp;
		Double tempScore;
		Coordinate bestMove = null;

		if (d == 0) {
			Object[] x = { evaluate(board), moveList.get(0) };
			return x;
		}
		bestScore = myBest;
		while (moveList.size() > 0) {
//			Board newBoard = new Board(board);
			Board newBoard = board;
			Coordinate newMove = moveList.get(0);
			newBoard.placeMove(newBoard.nextPlayer, newMove);
			temp = miniMaxWithAlphaBetaPruning(newBoard, d - 1, -theirBest, -bestScore);
			tempScore = -(Double) temp[0];
			if (tempScore > bestScore) {
				bestScore = tempScore;
				bestMove = newMove;
			}
			if (bestScore > theirBest) {
				Object[] x = { bestScore, bestMove };
				return x;
			}
			moveList.remove(0);
		}
		Object[] x = { bestScore, bestMove };
		return x;
	}

}
