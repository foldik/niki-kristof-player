package com.tictactoe.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.tictactoe.domain.User;
import com.tictactoe.http.request.IsMyTurnRequest;
import com.tictactoe.http.request.PutRequest;
import com.tictactoe.http.response.IsMyTurnResponse;
import com.tictactoe.http.response.PutResponse;
import com.tictactoe.json.deserializer.JsonDeserializer;
import com.tictactoe.json.serializer.JsonSerializer;

public class HttpManagger {

	private JsonDeserializer jsonDeSerializer;
	private JsonSerializer jsonSerializer;
	private HttpCommunicator communicator;

	public HttpManagger(JsonDeserializer jsonDeSerializer, JsonSerializer jsonSerializer, HttpCommunicator communicator) {
		this.jsonDeSerializer = jsonDeSerializer;
		this.jsonSerializer = jsonSerializer;
		this.communicator = communicator;
	}
	
	public void initializeConnection() {
		communicator.initializeConnection();
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
