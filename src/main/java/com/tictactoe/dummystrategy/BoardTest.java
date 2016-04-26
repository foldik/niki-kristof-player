package com.tictactoe.dummystrategy;

import java.util.Arrays;

import com.tictactoe.domain.Element;
import com.tictactoe.dummystrategy.model.Board;
import com.tictactoe.dummystrategy.model.LineHolder;
import com.tictactoe.dummystrategy.model.lineid.ColumnIdGenerator;
import com.tictactoe.dummystrategy.model.lineid.LeftDiagonalIdGenerator;
import com.tictactoe.dummystrategy.model.lineid.RightDiagonalIdGenerator;
import com.tictactoe.dummystrategy.model.lineid.RowIdGenerator;

public class BoardTest {

	public static void main(String[] args) {
		Board board = new Board(
				Arrays.asList(new LineHolder(new RowIdGenerator()), new LineHolder(new ColumnIdGenerator()),
						new LineHolder(new RightDiagonalIdGenerator()), new LineHolder(new LeftDiagonalIdGenerator())));

		long time = System.currentTimeMillis();
		for (int i = 0; i < 1000_000; i++) {
			board.add(randomElement());
		}

		long heapSize = Runtime.getRuntime().totalMemory();
		long heapMaxSize = Runtime.getRuntime().maxMemory();
		long heapFreeSize = Runtime.getRuntime().freeMemory();
		System.out.println("Heap m: " + heapMaxSize);
		System.out.println("Heap s: " + heapSize);
		System.out.println("Heap f: " + heapFreeSize);
		System.out.println("Delta: " + (System.currentTimeMillis() - time) + "ms");
	}

	private static Element randomElement() {
		return new Element((int) (Math.random() * 1000_000), (int) (Math.random() * 1000_000), "X");
	}

}
