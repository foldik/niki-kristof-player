package com.tictactoe.json.serializer;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class JsonSerializer {

	public String serialize(Object object) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(object);
	}
}
