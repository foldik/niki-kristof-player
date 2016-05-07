package com.tictactoe.dummystrategy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tictactoe.domain.Element;
import com.tictactoe.dummystrategy.model.Line;
import com.tictactoe.dummystrategy.model.LineHolder;
import com.tictactoe.dummystrategy.model.lineid.LineIdGenerator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

public class LineHolderTest {
	
	@Mock
	private LineIdGenerator lineIdGenerator;
	
	private LineHolder lineHolder;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		lineHolder = new LineHolder(lineIdGenerator);
	}

	@Test
	public void testWithOneLine() {
		//GIVEN
		Element element1 = new Element(0, 1, "X");
		Element element2 = new Element(10, 1, "X");
		when(lineIdGenerator.generateId(element1)).thenReturn(1);
		when(lineIdGenerator.generateId(element2)).thenReturn(1);
		
		//WHEN
		lineHolder.add(element1);
		lineHolder.add(element2);
		Map<Integer, Line> lines = lineHolder.getLines();
		
		//THEN
		assertEquals(lines.entrySet().size(), 1);
		
		Line line = lines.get(1);
		List<Element> elements = line.getSubLines();
		
		assertEquals(elements.size(), 2);
		assertEquals(elements.get(0), element1);
		assertEquals(elements.get(1), element2);
	}
	
	@Test
	public void testWithTwoLine() {
		//GIVEN
		Element element1 = new Element(0, 1, "X");
		Element element2 = new Element(10, 2, "X");
		when(lineIdGenerator.generateId(element1)).thenReturn(1);
		when(lineIdGenerator.generateId(element2)).thenReturn(2);
		
		//WHEN
		lineHolder.add(element1);
		lineHolder.add(element2);
		Map<Integer, Line> lines = lineHolder.getLines();
		
		//THEN
		assertEquals(lines.entrySet().size(), 2);
		
		Line line = lines.get(1);
		List<Element> elements = line.getSubLines();
		assertEquals(elements.size(), 1);
		assertEquals(elements.get(0), element1);
		
		Line line2 = lines.get(2);
		List<Element> elements2 = line2.getSubLines();
		assertEquals(elements2.size(), 1);
		assertEquals(elements2.get(0), element2);
	}
}
