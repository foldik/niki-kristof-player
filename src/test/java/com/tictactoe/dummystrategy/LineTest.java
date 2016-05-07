package com.tictactoe.dummystrategy;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tictactoe.domain.Element;
import com.tictactoe.dummystrategy.model.Line;
import com.tictactoe.dummystrategy.model.SubLine;

public class LineTest {

	@Test
	public void testColumn() {
		// GIVEN
		Line line = new Line();
		line.add(new Element(0, 4, "X"));
		line.add(new Element(0, 2, "X"));
		line.add(new Element(0, 1, "X"));
		line.add(new Element(0, 3, "X"));

		// WHEN
		List<SubLine> subLines = line.getSubLines();

		// THEN
		assertEquals(1, subLines.size());
		assertEquals(new SubLine(1, 4, "X"), subLines.get(0));
	}

	@Test
	public void testRow() {
		// GIVEN
		Line line = new Line();
		line.add(new Element(4, 0, "X"));
		line.add(new Element(2, 0, "X"));
		line.add(new Element(1, 0, "X"));
		line.add(new Element(3, 0, "X"));

		// WHEN
		List<SubLine> subLines = line.getSubLines();

		// THEN
		assertEquals(1, subLines.size());

		assertEquals(new SubLine(1, 4, "X"), subLines.get(0));
	}

	@Test
	public void testRightDiagonal() {
		// GIVEN
		Line line = new Line();
		line.add(new Element(1, 1, "X"));
		line.add(new Element(-1, 3, "X"));
		line.add(new Element(0, 2, "X"));
		line.add(new Element(-2, 4, "X"));

		// WHEN
		List<SubLine> subLines = line.getSubLines();

		// THEN
		assertEquals(1, subLines.size());

		assertEquals(new SubLine(1, 4, "X"), subLines.get(0));
	}

	@Test
	public void testLeftDiagonal() {
		// GIVEN
		Line line = new Line();
		line.add(new Element(2, 1, "X"));
		line.add(new Element(4, 3, "X"));
		line.add(new Element(3, 2, "X"));
		line.add(new Element(5, 4, "X"));

		// WHEN
		List<Element> elements = line.getSubLines();

		// THEN
		assertEquals(new Element(2, 1, "X"), elements.get(0));
		assertEquals(new Element(3, 2, "X"), elements.get(1));
		assertEquals(new Element(4, 3, "X"), elements.get(2));
		assertEquals(new Element(5, 4, "X"), elements.get(3));
	}
}
