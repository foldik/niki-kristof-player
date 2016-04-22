package com.tictactoe.json.serializer;

import com.tictactoe.domain.IsMyTurnRequest;
import com.tictactoe.domain.PutRequest;

public class JsonSerializer {
	
	private PutRequestSerializer putRequestSerializer;
	private IsMyTurnRequestSerializer isMyTurnRequestSerializer;

	public JsonSerializer(PutRequestSerializer putRequestSerializer, IsMyTurnRequestSerializer isMyTurnRequestSerializer) {
		this.putRequestSerializer = putRequestSerializer;
		this.isMyTurnRequestSerializer = isMyTurnRequestSerializer;
	}
	
	public String serializePutRequest(PutRequest putRequest) {
		return putRequestSerializer.serialize(putRequest);
	}
	
	public String serializeIsMyTurnRequest(IsMyTurnRequest isMyTurnRequest) {
		return isMyTurnRequestSerializer.serialize(isMyTurnRequest);
	}

}
