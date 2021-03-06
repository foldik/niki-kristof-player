package com.tictactoe.json.deserializer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.Element;
import com.tictactoe.http.domain.response.Game;
import com.tictactoe.http.domain.response.IsMyTurnResponse;
import com.tictactoe.http.domain.response.PutResponse;
import com.tictactoe.http.domain.response.RegistrationResponse;

public class JsonDeserializerTest {

	private JsonDeserializer jsonDeserializer;
	
	@Before
	public void setUp() {
		jsonDeserializer = new JsonDeserializer();
	}
	
	@Test
	public void testRegistrationResponseDeserialization() {
		//GIVEN
		String json = "{\"statusCode\": 200, \"message\": \"ok\", \"uuid\": \"1234567890123456789\",\"type\": \"x\", \"gid\": \"gid-1234567890123456789\"}";
		
		//WHEN
		RegistrationResponse registrationResponse = jsonDeserializer.deserialize(json, RegistrationResponse.class);
		
		//THEN
		assertEquals(200, registrationResponse.getStatusCode());
		assertEquals("ok", registrationResponse.getMessage());
		assertEquals("1234567890123456789", registrationResponse.getUuid());
		assertEquals("x", registrationResponse.getType());
		assertEquals("gid-1234567890123456789", registrationResponse.getGameId());
	}
	
	@Test
	public void testPutResponseDeserialization() {
		//GIVEN
		String json = "{\"statusCode\": 200, \"message\": \"ok\"}";
		
		//WHEN
		PutResponse putResponse = jsonDeserializer.deserialize(json, PutResponse.class);
		
		//THEN
		assertEquals(200, putResponse.getStatusCode());
		assertEquals("ok", putResponse.getMessage());
	}
	
	@Test
	public void testIsMyTurnResponseDeserialization() {
		//GIVEN
		String json = "{\"statusCode\": 200, \"message\": \"ok\", \"isMyTurn\": \"true\",\"lastMove\": {\"x\": 10, \"y\": 20, \"t\": \"x\"}}";
		
		//WHEN
		IsMyTurnResponse isMyTurnResponse = jsonDeserializer.deserialize(json, IsMyTurnResponse.class);
		
		//THEN
		assertEquals(200, isMyTurnResponse.getStatusCode());
		assertEquals("ok", isMyTurnResponse.getMessage());
		assertEquals(true, isMyTurnResponse.isMyTurn());
		assertEquals(10, isMyTurnResponse.getLastMove().getX());
		assertEquals(20, isMyTurnResponse.getLastMove().getY());
		assertEquals("x", isMyTurnResponse.getLastMove().getType());
	}
	
	@Test
	public void testStatusResponseDeserialization() {
		//GIVEN
		String value = "[{\"x\": 10, \"y\": 20, \"t\": \"x\"}, {\"x\": 11, \"y\": 21, \"t\": \"o\"}]";
				
		//WHEN
		Element[] elements = jsonDeserializer.deserialize(value, Element[].class);
		
		//THEN
		assertEquals(2, elements.length);
		
		assertEquals(10, elements[0].getX());
		assertEquals(20, elements[0].getY());
		assertEquals("x", elements[0].getType());
		
		assertEquals(11, elements[1].getX());
		assertEquals(21, elements[1].getY());
		assertEquals("o", elements[1].getType());
	}
	
	@Test
	public void testGameListDeserialization() {
		//GIVEN
		String json = "[{\"gid\":\"123-gid\"},{\"gid\":\"456-gid\"}]";
		
		//WHEN
		Game[] games = jsonDeserializer.deserialize(json, Game[].class);
		
		//THEN
		assertEquals(2, games.length);
		
		assertEquals("123-gid", games[0].getGameId());
		
		assertEquals("456-gid", games[1].getGameId());
	}
}
