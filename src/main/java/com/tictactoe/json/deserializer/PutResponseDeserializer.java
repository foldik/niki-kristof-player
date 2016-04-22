package com.tictactoe.json.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.domain.PutResponse;

public class PutResponseDeserializer {
	
	public PutResponse deserialize(String value){
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(value, PutResponse.class);
	}

}
