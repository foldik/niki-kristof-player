package com.tictactoe.json;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.domain.User;

import static org.junit.Assert.*;

public class UserDeserializerTest {
	
	private UserDeserializer userDeserializer;
	
	@Before
	public void setUp() {
		userDeserializer = new UserDeserializer();
	}

	@Test
	public void testUserDeserializer() {
		//GIVEN
		String json = "{\"uuid\": \"1234567890123456789\",\"type\": \"x\", \"gid\": \"gid-1234567890123456789\"}";
		
		//WHEN
		User user = userDeserializer.deserialize(json);
		
		//THEN
		assertEquals("1234567890123456789", user.getUuid());
		assertEquals("x", user.getType());
		assertEquals("gid-1234567890123456789", user.getGid());
	}
	
	
}
