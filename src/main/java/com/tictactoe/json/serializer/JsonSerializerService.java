package com.tictactoe.json.serializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.http.request.IsMyTurnRequest;
import com.tictactoe.http.request.PutRequest;

@Service
public class JsonSerializerService {
	
	private PutRequestSerializer putRequestSerializer;
	private IsMyTurnRequestSerializer isMyTurnRequestSerializer;

	@Autowired
	public JsonSerializerService(PutRequestSerializer putRequestSerializer, IsMyTurnRequestSerializer isMyTurnRequestSerializer) {
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
