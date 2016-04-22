package com.tictactoe.json;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.PutResponse;
import com.tictactoe.json.deserializer.PutResponseDeserializer;

import static org.junit.Assert.*;

public class PutResponseDeserializerTest {

	private PutResponseDeserializer putResponseDeserializer;
	
	@Before
	public void setUp() {
		putResponseDeserializer = new PutResponseDeserializer();
	}
	
	@Test
	public void testSingleElement(){
		//GIVEN
		String value = "{\"statusCode\": 200, \"message\": \"ok\"}";
		
		//WHEN
		PutResponse putResponse = putResponseDeserializer.deserialize(value);
		
		//THEN
		assertEquals(200, putResponse.getStatusCode());
		assertEquals("ok", putResponse.getMessage());
	}
}
