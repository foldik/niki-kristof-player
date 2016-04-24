package com.tictactoe.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.domain.User;
import com.tictactoe.http.domain.request.IsMyTurnRequest;
import com.tictactoe.http.domain.request.PutRequest;
import com.tictactoe.http.domain.request.StatusRequest;
import com.tictactoe.http.domain.response.IsMyTurnResponse;
import com.tictactoe.http.domain.response.PutResponse;
import com.tictactoe.http.domain.response.StatusResponse;
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
		String response = communicator.register();
		return jsonDeSerializer.parseUser(response);
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
	
	public StatusResponse getStatus(StatusRequest request) throws ClientProtocolException, IOException {
		String json = jsonSerializer.serializeStatusRequest(request);
		String response = communicator.getStatus(json);
		return jsonDeSerializer.parseStatusResponse(response);
	}
	
	public void closeConnection() {
		communicator.closeConnection();
	}

}
