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

public class RightDiagonalEvaluatorTest {

	@Mock
	private Line line;
	
	private RightDiagonalEvaluator rightDiagonalEvaluator;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		rightDiagonalEvaluator = new RightDiagonalEvaluator();
	}
	
	@Test
	public void testWithFourXAndOneSideWinner() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(4, 0, BorderPiece.X),
				new Element(3, 1, BorderPiece.X),
				new Element(2, 3, BorderPiece.X),
				new Element(1, 3, BorderPiece.X),
				new Element(0, 4, BorderPiece.O)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rightDiagonalEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(1, winnerCoordinates.size());
		
		assertEquals(new Coordinate(5, -1), winnerCoordinates.get(0));
	}
	
	@Test
	public void testWithFourXTwoSideWinner() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(4, 1, BorderPiece.X),
				new Element(3, 2, BorderPiece.X),
				new Element(2, 3, BorderPiece.X),
				new Element(1, 4, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rightDiagonalEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(2, winnerCoordinates.size());
		
		assertEquals(new Coordinate(5, -1), winnerCoordinates.get(0));
		assertEquals(new Coordinate(0, 5), winnerCoordinates.get(1));
	}
	
	@Test
	public void testWithOneXOneEmptyThreeX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(4, 0, BorderPiece.X),
				new Element(2, 2, BorderPiece.X),
				new Element(1, 3, BorderPiece.X),
				new Element(0, 4, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rightDiagonalEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(1, winnerCoordinates.size());
		
		assertEquals(new Coordinate(3, 1), winnerCoordinates.get(0));
	}
	
	@Test
	public void testWithOneXOneEmptyFourX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(4, 0, BorderPiece.X),
				new Element(3, 1, BorderPiece.X),
				new Element(2, 2, BorderPiece.X),
				new Element(1, 3, BorderPiece.X),
				new Element(-1, 6, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rightDiagonalEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(2, winnerCoordinates.size());
		
		assertEquals(new Coordinate(5, -1), winnerCoordinates.get(0));
		assertEquals(new Coordinate(0, 5), winnerCoordinates.get(0));
	}
	
	@Test
	public void testWithOneXTwoEmptyThreeX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(4, 0, BorderPiece.X),
				new Element(3, 1, BorderPiece.X),
				new Element(2, 2, BorderPiece.X),
				new Element(-1, 5, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rightDiagonalEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(0, winnerCoordinates.size());
	}
	
	@Test
	public void testWithFourXBothSidesClosed() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(6, 1, BorderPiece.O),
				new Element(5, 2, BorderPiece.X),
				new Element(4, 3, BorderPiece.X),
				new Element(3, 4, BorderPiece.X),
				new Element(2, 5, BorderPiece.X),
				new Element(1, 6, BorderPiece.O)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rightDiagonalEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(0, winnerCoordinates.size());
	}
	
	@Test
	public void testWithOneXOneOThreeX() {
		// GIVEN
		List<Element> elements = Arrays.asList(
				new Element(5, 1, BorderPiece.X),
				new Element(4, 2, BorderPiece.O),
				new Element(3, 3, BorderPiece.X),
				new Element(2, 4, BorderPiece.X),
				new Element(1, 5, BorderPiece.X)
				);
		when(line.getSubLines()).thenReturn(elements);
		
		//WHEN
		List<Coordinate> winnerCoordinates = rightDiagonalEvaluator.evaluate(line, BorderPiece.X);
		
		//THEN
		assertEquals(0, winnerCoordinates.size());
	}
	
}
