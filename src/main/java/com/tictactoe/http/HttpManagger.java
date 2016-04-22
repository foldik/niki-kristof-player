package com.tictactoe.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.tictactoe.domain.User;
import com.tictactoe.json.deserializer.JsonDeserializer;

public class HttpManagger {

	private JsonDeserializer jsonSerializer;
	private HttpCommunicator communicator;

	public HttpManagger(JsonDeserializer jsonSerializer, HttpCommunicator communicator) {
		this.jsonSerializer = jsonSerializer;
		this.communicator = communicator;
	}
	
	public void initializeConnection() {
		communicator.initializeConnection();
	}

	public User register() throws ClientProtocolException, IOException {
		return jsonSerializer.parseUser(communicator.register());
	}
	
	public void closeConnection() {
		communicator.closeConnection();
	}

}
