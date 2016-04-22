package com.tictactoe.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.domain.User;

public class UserDeserializer {
	
	public User deserialize(String value) {
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(value, User.class);
	}

}
