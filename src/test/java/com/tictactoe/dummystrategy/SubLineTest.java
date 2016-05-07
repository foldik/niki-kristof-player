package com.tictactoe.dummystrategy;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.tictactoe.dummystrategy.model.SubLine;

public class SubLineTest {

	@Test
	public void testMergeSmallerToGreater() {
		SubLine subLine1 = new SubLine(0, 1, "X");
		SubLine subLine2 = new SubLine(3, 4, "X");

		SubLine merged = subLine1.merge(subLine2);

		assertEquals(new SubLine(0, 4, "X"), merged);
	}

	@Test
	public void testMergeGreaterToSmaller() {
		SubLine subLine1 = new SubLine(0, 1, "X");
		SubLine subLine2 = new SubLine(3, 4, "X");

		SubLine merged = subLine2.merge(subLine1);

		assertEquals(new SubLine(0, 4, "X"), merged);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMergeWithDifferentCharacter() {
		SubLine subLine1 = new SubLine(0, 1, "O");
		SubLine subLine2 = new SubLine(3, 4, "X");

		subLine1.merge(subLine2);
	}
	
	@Test
	public void testCutWithStartIndex() {
		SubLine subLine = new SubLine(0, 3, "X");
		
		List<SubLine> cuttedLines = subLine.cut(0);
		
		assertEquals(Arrays.asList(new SubLine(1, 3, "X")), cuttedLines);
	}
	
	@Test
	public void testCutWithEndIndex() {
		SubLine subLine = new SubLine(0, 3, "X");
		
		List<SubLine> cuttedLines = subLine.cut(3);
		
		assertEquals(Arrays.asList(new SubLine(0, 2, "X")), cuttedLines);
	}
	
	@Test
	public void testCutWithInnerPoint() {
		SubLine subLine = new SubLine(0, 3, "X");
		
		List<SubLine> cuttedLines = subLine.cut(1);
		
		assertEquals(Arrays.asList(new SubLine(0, 0, "X"),  new SubLine(2, 3, "X")), cuttedLines);
	}
}
