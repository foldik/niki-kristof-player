package com.tictactoe.json.deserializer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.domain.Element;
import com.tictactoe.domain.User;
import com.tictactoe.http.domain.response.IsMyTurnResponse;
import com.tictactoe.http.domain.response.PutResponse;
import com.tictactoe.http.domain.response.StatusResponse;

@Service
public class JsonDeserializerService {

	private JsonDeserializer jsonDeserializer;

	@Autowired
	public JsonDeserializerService(JsonDeserializer jsonDeserializer) {
		this.jsonDeserializer = jsonDeserializer;
	}

	public User parseUser(String userJson) {
		if (userJson == null) {
			return null;
		}
		return jsonDeserializer.deserialize(userJson,  User.class);
	}

	public PutResponse parsePutResponse(String json) {
		if (json == null) {
			return null;
		}
		return jsonDeserializer.deserialize(json, PutResponse.class);
	}
	
	public IsMyTurnResponse parseIsMyTurnResponse(String json) {
		if (json == null) {
			return null;
		}
		return jsonDeserializer.deserialize(json, IsMyTurnResponse.class);
	}
	
	public StatusResponse parseStatusResponse(String json) {
		if (json == null) {
			return null;
		}
		return new StatusResponse(Arrays.asList(jsonDeserializer.deserialize(json, Element[].class)));
	}
}
