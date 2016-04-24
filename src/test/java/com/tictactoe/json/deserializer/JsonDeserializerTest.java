package com.tictactoe.json.deserializer;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.Element;
import com.tictactoe.domain.User;
import com.tictactoe.http.domain.response.IsMyTurnResponse;
import com.tictactoe.http.domain.response.PutResponse;

public class JsonDeserializerTest {

	private JsonDeserializer jsonDeserializer;
	
	@Before
	public void setUp() {
		jsonDeserializer = new JsonDeserializer();
	}
	
	@Test
	public void testUserDeserialization() {
		//GIVEN
		String json = "{\"uuid\": \"1234567890123456789\",\"type\": \"x\", \"gid\": \"gid-1234567890123456789\"}";
		
		//WHEN
		User user = jsonDeserializer.deserialize(json, User.class);
		
		//THEN
		assertEquals("1234567890123456789", user.getUuid());
		assertEquals("x", user.getType());
		assertEquals("gid-1234567890123456789", user.getGid());
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
		String json = "{\"isMyTurn\": \"true\",\"lastMove\": {\"x\": 10, \"y\": 20, \"t\": \"x\"}}";
		
		//WHEN
		IsMyTurnResponse isMyTurnResponse = jsonDeserializer.deserialize(json, IsMyTurnResponse.class);
		
		//THEN
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
		List<Element> elements = Arrays.asList(jsonDeserializer.deserialize(value, Element[].class));
		
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
