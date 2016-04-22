package com.tictactoe.json.deserializer;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tictactoe.http.response.PutResponse;

@Component
public class PutResponseDeserializer {
	
	public PutResponse deserialize(String value){
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(value, PutResponse.class);
	}

}
