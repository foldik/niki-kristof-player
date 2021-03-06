package com.tictactoe.dummystrategy.evaluator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tictactoe.domain.BorderPiece;
import com.tictactoe.domain.Coordinate;
import com.tictactoe.domain.Element;
import com.tictactoe.dummystrategy.model.Line;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class RowEvaluatorTest {

	@Mock
	private Line line;
	
	private RowEvaluator rowEvaluator;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		rowEvaluator = new RowEvaluator();
	}
	
	@Test
	public void testWithFourXAndOneSideWinner() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(0, 0, BorderPiece.O),
				new Element(1, 0, BorderPiece.X),
				new Element(2, 0, BorderPiece.X),
				new Element(3, 0, BorderPiece.X),
				new Element(4, 0, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rowEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(1, winnerCoordinates.size());
		
		assertEquals(new Coordinate(5, 0), winnerCoordinates.get(0));
	}
	
	@Test
	public void testWithFourXTwoSideWinner() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(1, 0, BorderPiece.X),
				new Element(2, 0, BorderPiece.X),
				new Element(3, 0, BorderPiece.X),
				new Element(4, 0, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rowEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(2, winnerCoordinates.size());
		
		assertEquals(new Coordinate(0, 0), winnerCoordinates.get(0));
		assertEquals(new Coordinate(5, 0), winnerCoordinates.get(1));
	}
	
	@Test
	public void testWithOneXOneEmptyThreeX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(0, 0, BorderPiece.X),
				new Element(2, 0, BorderPiece.X),
				new Element(3, 0, BorderPiece.X),
				new Element(4, 0, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rowEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(1, winnerCoordinates.size());
		
		assertEquals(new Coordinate(1, 0), winnerCoordinates.get(0));
	}
	
	@Test
	public void testWithOneXOneEmptyFourX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(-2, 0, BorderPiece.X),
				new Element(0, 0, BorderPiece.X),
				new Element(2, 0, BorderPiece.X),
				new Element(3, 0, BorderPiece.X),
				new Element(4, 0, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rowEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(2, winnerCoordinates.size());
		
		assertEquals(new Coordinate(-1, 0), winnerCoordinates.get(0));
		assertEquals(new Coordinate(5, 0), winnerCoordinates.get(0));
	}
	
	@Test
	public void testWithOneXTwoEmptyThreeX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(-1, 0, BorderPiece.X),
				new Element(2, 0, BorderPiece.X),
				new Element(3, 0, BorderPiece.X),
				new Element(4, 0, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rowEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(0, winnerCoordinates.size());
	}
	
	@Test
	public void testWithFourXBothSidesClosed() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(1, 0, BorderPiece.O),
				new Element(2, 0, BorderPiece.X),
				new Element(3, 0, BorderPiece.X),
				new Element(4, 0, BorderPiece.X),
				new Element(5, 0, BorderPiece.X),
				new Element(6, 0, BorderPiece.O)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rowEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(0, winnerCoordinates.size());
	}
	
	@Test
	public void testWithOneXOneOThreeX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(1, 0, BorderPiece.X),
				new Element(2, 0, BorderPiece.O),
				new Element(3, 0, BorderPiece.X),
				new Element(4, 0, BorderPiece.X),
				new Element(5, 0, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rowEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(0, winnerCoordinates.size());
	}
	
}
