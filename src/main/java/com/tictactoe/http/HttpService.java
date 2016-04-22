package com.tictactoe.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.domain.User;
import com.tictactoe.http.request.IsMyTurnRequest;
import com.tictactoe.http.request.PutRequest;
import com.tictactoe.http.response.IsMyTurnResponse;
import com.tictactoe.http.response.PutResponse;
import com.tictactoe.json.deserializer.JsonDeserializerService;
import com.tictactoe.json.serializer.JsonSerializerService;

@Service
public class HttpService {

	private JsonDeserializerService jsonDeSerializer;
	private JsonSerializerService jsonSerializer;
	private HttpCommunicatorService communicator;

	@Autowired
	public HttpService(JsonDeserializerService jsonDeSerializer, JsonSerializerService jsonSerializer, HttpCommunicatorService communicator) {
		this.jsonDeSerializer = jsonDeSerializer;
		this.jsonSerializer = jsonSerializer;
		this.communicator = communicator;
	}
	
	public void initializeConnection(HttpClient httpClient) {
		communicator.initializeConnection(httpClient);
	}

	public User register() throws ClientProtocolException, IOException {
		return jsonDeSerializer.parseUser(communicator.register());
	}
	
	public PutResponse put(PutRequest putRequest) throws IOException {
		String json = jsonSerializer.serializePutRequest(putRequest);
		String response = communicator.put(json);
		return jsonDeSerializer.parsePutResponse(response);
	}
	
	public IsMyTurnResponse isMyTurn(IsMyTurnRequest isMyTurnRequest) throws IOException {
		String json = jsonSerializer.serializeIsMyTurnRequest(isMyTurnRequest);
		String response = communicator.isMyTurn(json);
		return jsonDeSerializer.parseIsMyTurnResponse(response);
	}
	
	public void closeConnection() {
		communicator.closeConnection();
	}

}
