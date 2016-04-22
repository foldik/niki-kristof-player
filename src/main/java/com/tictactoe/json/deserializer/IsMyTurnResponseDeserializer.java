package com.tictactoe.json.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.domain.IsMyTurnResponse;

public class IsMyTurnResponseDeserializer {

	public IsMyTurnResponse deserialize(String json) {
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(json, IsMyTurnResponse.class);
	}
}
