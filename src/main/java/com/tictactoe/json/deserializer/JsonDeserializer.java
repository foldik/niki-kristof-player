package com.tictactoe.json.deserializer;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class JsonDeserializer {

	public <T> T deserialize(String json, Class<T> clazz) {
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(json, clazz);
	}
}
