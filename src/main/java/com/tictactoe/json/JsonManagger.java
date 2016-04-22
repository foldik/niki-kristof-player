package com.tictactoe.json;

import com.tictactoe.domain.User;

public class JsonManagger {
	
	private UserDeserializer userDeserializer;

	public JsonManagger(UserDeserializer userDeserializer) {
		this.userDeserializer = userDeserializer;
	}
	
	public User parseUser(String userJson) {
		if (userJson == null) {
			return null;
		}
		return userDeserializer.deserialize(userJson);
	}

}
