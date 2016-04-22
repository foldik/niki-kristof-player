package com.tictactoe.json.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.http.request.PutRequest;

public class PutRequestSerializer {

	public String serialize(PutRequest putRequest) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(putRequest);
	}

}
