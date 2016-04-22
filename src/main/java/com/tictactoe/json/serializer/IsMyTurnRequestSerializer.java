package com.tictactoe.json.serializer;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.http.request.IsMyTurnRequest;

@Component
public class IsMyTurnRequestSerializer {

	public String serialize(IsMyTurnRequest isMyTurnRequest) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(isMyTurnRequest);
	}
}
