package com.tictactoe.json.deserializer;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.http.response.IsMyTurnResponse;

@Component
public class IsMyTurnResponseDeserializer {

	public IsMyTurnResponse deserialize(String json) {
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(json, IsMyTurnResponse.class);
	}
}
