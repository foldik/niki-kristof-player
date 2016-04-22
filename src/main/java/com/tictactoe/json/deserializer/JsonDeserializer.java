package com.tictactoe.json.deserializer;

import com.tictactoe.domain.User;
import com.tictactoe.http.response.IsMyTurnResponse;
import com.tictactoe.http.response.PutResponse;

public class JsonDeserializer {

	private UserDeserializer userDeserializer;
	private ElementDeserializer elementDeserializer;
	private PutResponseDeserializer putResponseDeserializer;
	private IsMyTurnResponseDeserializer isMyTurnResponseDeserializer;

	public JsonDeserializer(UserDeserializer userDeserializer, ElementDeserializer elementDeserializer,
			PutResponseDeserializer putResponseDeserializer, IsMyTurnResponseDeserializer isMyTurnResponseDeserializer) {
		this.userDeserializer = userDeserializer;
		this.elementDeserializer = elementDeserializer;
		this.putResponseDeserializer = putResponseDeserializer;
		this.isMyTurnResponseDeserializer = isMyTurnResponseDeserializer;
	}

	public User parseUser(String userJson) {
		if (userJson == null) {
			return null;
		}
		return userDeserializer.deserialize(userJson);
	}

	public PutResponse parsePutResponse(String json) {
		if (json == null) {
			return null;
		}
		return putResponseDeserializer.deserialize(json);
	}
	
	public IsMyTurnResponse parseIsMyTurnResponse(String json) {
		if (json == null) {
			return null;
		}
		return isMyTurnResponseDeserializer.deserialize(json);
	}
}
