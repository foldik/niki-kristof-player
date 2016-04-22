package com.tictactoe.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.domain.PutRequest;

public class PutRequestSerializer {

	public String serialize(PutRequest putRequest) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(putRequest);
	}

}
