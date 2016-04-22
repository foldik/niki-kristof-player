package com.tictactoe.json.deserializer;

import com.tictactoe.domain.User;

public class JsonDeserializer {

	private UserDeserializer userDeserializer;
	private ElementDeserializer elementDeserializer;
	private PutResponseDeserializer putResponseDeserializer;

	public JsonDeserializer(UserDeserializer userDeserializer, ElementDeserializer elementDeserializer,
			PutResponseDeserializer putResponseDeserializer) {
		this.userDeserializer = userDeserializer;
		this.elementDeserializer = elementDeserializer;
		this.putResponseDeserializer = putResponseDeserializer;
	}

	public User parseUser(String userJson) {
		if (userJson == null) {
			return null;
		}
		return userDeserializer.deserialize(userJson);
	}

}
