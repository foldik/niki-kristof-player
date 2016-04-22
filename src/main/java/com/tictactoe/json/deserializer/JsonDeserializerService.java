package com.tictactoe.json.deserializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.domain.User;
import com.tictactoe.http.response.IsMyTurnResponse;
import com.tictactoe.http.response.PutResponse;

@Service
public class JsonDeserializerService {

	private UserDeserializer userDeserializer;
	private ElementDeserializer elementDeserializer;
	private PutResponseDeserializer putResponseDeserializer;
	private IsMyTurnResponseDeserializer isMyTurnResponseDeserializer;

	@Autowired
	public JsonDeserializerService(UserDeserializer userDeserializer, ElementDeserializer elementDeserializer,
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
