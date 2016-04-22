package com.tictactoe.json;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.IsMyTurnResponse;
import com.tictactoe.json.deserializer.IsMyTurnResponseDeserializer;

import static org.junit.Assert.*;

public class IsMyTurnResponseDeserializerTest {
	
	private IsMyTurnResponseDeserializer isMyTurnResponseDeserializer;
	
	@Before
	public void setUp() {
		isMyTurnResponseDeserializer = new IsMyTurnResponseDeserializer();
	}
	
	@Test
	public void testWithNormalResponse() {
		String json = "{\"isMyTurn\": \"true\",\"lastMove\": {\"x\": 10, \"y\": 20, \"t\": \"x\"}}";
		IsMyTurnResponse isMyTurnResponse = isMyTurnResponseDeserializer.deserialize(json);
		assertEquals(true, isMyTurnResponse.isMyTurn());
		assertEquals(10, isMyTurnResponse.getLastMove().getX());
		assertEquals(20, isMyTurnResponse.getLastMove().getY());
		assertEquals("x", isMyTurnResponse.getLastMove().getType());
	}

}
