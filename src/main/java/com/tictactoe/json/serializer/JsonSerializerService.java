package com.tictactoe.json.serializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.http.domain.request.IsMyTurnRequest;
import com.tictactoe.http.domain.request.PutRequest;
import com.tictactoe.http.domain.request.RegistrationRequest;
import com.tictactoe.http.domain.request.StatusRequest;

@Service
public class JsonSerializerService {
	
	private JsonSerializer jsonSerializer;

	@Autowired
	public JsonSerializerService(JsonSerializer jsonSerializer) {
		this.jsonSerializer = jsonSerializer;
	}
	
	public String serializeRegistrationRequest(RegistrationRequest registrationRequest) {
		return jsonSerializer.serialize(registrationRequest);
	}
	
	public String serializePutRequest(PutRequest putRequest) {
		return jsonSerializer.serialize(putRequest);
	}
	
	public String serializeIsMyTurnRequest(IsMyTurnRequest isMyTurnRequest) {
		return jsonSerializer.serialize(isMyTurnRequest);
	}

	public String serializeStatusRequest(StatusRequest statusRequest){
		return jsonSerializer.serialize(statusRequest);
	}
	
}
