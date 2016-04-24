package com.tictactoe.json.serializer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.http.domain.request.IsMyTurnRequest;
import com.tictactoe.http.domain.request.PutRequest;
import com.tictactoe.http.domain.request.StatusRequest;

public class JsonSerializerTest {

	private JsonSerializer jsonSerializer;
	
	@Before
	public void setUp() {
		jsonSerializer = new JsonSerializer();
	}
	
	@Test
	public void testPutRequestSerialization() {
		//GIVEN
		PutRequest putRequest = new PutRequest("123456789", 1, 2);
		
		//WHEN
		String json = jsonSerializer.serialize(putRequest);
		
		//THEN
		assertEquals("{\"uuid\":\"123456789\",\"x\":1,\"y\":2}", json);
	}
	
	@Test
	public void testIsMyTurnRequestSerialization() {
		//GIVEN
		IsMyTurnRequest isMyTurnRequest = new IsMyTurnRequest("123456789");
		
		//WHEN
		String json = jsonSerializer.serialize(isMyTurnRequest);
		
		//THEN
		assertEquals("{\"uuid\":\"123456789\"}", json);
	}
	
	@Test
	public void testStatusRequestSerialization() {
		//GIVEN
		StatusRequest statusRequest = new StatusRequest("123456789-gid");
		
		//WHEN
		String json = jsonSerializer.serialize(statusRequest);
		
		assertEquals("{\"gid\":\"123456789-gid\"}", json);
	}
}
