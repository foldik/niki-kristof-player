package com.tictactoe.json;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.Element;
import com.tictactoe.json.ElementDeserializer;

import static org.junit.Assert.*;

import java.util.List;

public class ElementDeserializerTest {

	private ElementDeserializer elementParser;
	
	@Before
	public void setUp() {
		elementParser = new ElementDeserializer();
	}
	
	@Test
	public void testSingleElement(){
		//GIVEN
		String value = "{\"x\": 10, \"y\": 20, \"t\": \"x\"}";
		
		//WHEN
		Element element = elementParser.deserializeElement(value);
		
		//THEN
		assertEquals(10, element.getX());
		assertEquals(20, element.getY());
		assertEquals("x", element.getType());
	}
	
	@Test
	public void testWithListOfelements(){
		//GIVEN
		String value = "{\"data\": [{\"x\": 10, \"y\": 20, \"t\": \"x\"}, {\"x\": 11, \"y\": 21, \"t\": \"o\"}]}";
		
		//WHEN
		List<Element> elements = elementParser.deserializeElements(value);
		
		//THEN
		assertEquals(2, elements.size());
		
		assertEquals(10, elements.get(0).getX());
		assertEquals(20, elements.get(0).getY());
		assertEquals("x", elements.get(0).getType());
		
		assertEquals(11, elements.get(1).getX());
		assertEquals(21, elements.get(1).getY());
		assertEquals("o", elements.get(1).getType());
	}
}
