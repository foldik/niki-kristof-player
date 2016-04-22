package com.tictactoe.json;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.PutRequest;
import com.tictactoe.json.serializer.PutRequestSerializer;

import static org.junit.Assert.*;

public class PutRequestSerializerTest {

	private PutRequestSerializer putRequestSerializer;
	
	@Before
	public void setUp() {
		putRequestSerializer = new PutRequestSerializer();
	}
	
	@Test
	public void testPutRequestSerializer() {
		//GIVEN
		PutRequest putRequest = new PutRequest("123456789", 1, 2);
		
		//WHEN
		String json = putRequestSerializer.serialize(putRequest);
		
		//THEN
		assertEquals("{\"uuid\":\"123456789\",\"x\":1,\"y\":2}", json);
	}
}
