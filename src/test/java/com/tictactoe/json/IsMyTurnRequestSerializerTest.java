package com.tictactoe.json;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.IsMyTurnRequest;
import com.tictactoe.json.serializer.IsMyTurnRequestSerializer;

import static org.junit.Assert.*;

public class IsMyTurnRequestSerializerTest {
	
	private IsMyTurnRequestSerializer isMyTurnRequestSerializer;
	
	@Before
	public void setUp() {
		isMyTurnRequestSerializer = new IsMyTurnRequestSerializer();
	}
	
	@Test
	public void testWithNormalRequest() {
		IsMyTurnRequest isMyTurnRequest = new IsMyTurnRequest("123456789");
		String json = isMyTurnRequestSerializer.serialize(isMyTurnRequest);
		assertEquals("{\"uuid\":\"123456789\"}", json);
	}
}
