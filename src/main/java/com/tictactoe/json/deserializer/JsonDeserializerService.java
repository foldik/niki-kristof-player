package com.tictactoe.json.deserializer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.domain.Element;
import com.tictactoe.http.domain.response.Game;
import com.tictactoe.http.domain.response.GameListResponse;
import com.tictactoe.http.domain.response.IsMyTurnResponse;
import com.tictactoe.http.domain.response.PutResponse;
import com.tictactoe.http.domain.response.RegistrationResponse;
import com.tictactoe.http.domain.response.StatusResponse;

@Service
public class JsonDeserializerService {

	private JsonDeserializer jsonDeserializer;

	@Autowired
	public JsonDeserializerService(JsonDeserializer jsonDeserializer) {
		this.jsonDeserializer = jsonDeserializer;
	}

	public RegistrationResponse parseRegistrationResponse(String userJson) {
		if (userJson == null) {
			return null;
		}
		return jsonDeserializer.deserialize(userJson,  RegistrationResponse.class);
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

	public GameListResponse parseGameListResponse(String json) {
		if (json == null) {
			return null;
		}
		return new GameListResponse(Arrays.asList(jsonDeserializer.deserialize(json, Game[].class)));
	}
}
