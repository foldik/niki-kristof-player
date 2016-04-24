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
import com.tictactoe.http.domain.response.GameListResponse;
import com.tictactoe.http.domain.response.IsMyTurnResponse;
import com.tictactoe.http.domain.response.PutResponse;
import com.tictactoe.http.domain.response.StatusResponse;
import com.tictactoe.json.deserializer.JsonDeserializerService;
import com.tictactoe.json.serializer.JsonSerializerService;

@Service
public class GameService {

	private JsonDeserializerService jsonDeserializerService;
	private JsonSerializerService jsonSerializerService;
	private HttpCommunicatorService httpCommunicatorService;

	@Autowired
	public GameService(JsonDeserializerService jsonDeserializerService, JsonSerializerService jsonSerializerService, HttpCommunicatorService communicator) {
		this.jsonDeserializerService = jsonDeserializerService;
		this.jsonSerializerService = jsonSerializerService;
		this.httpCommunicatorService = communicator;
	}
	
	public void initializeConnection(HttpClient httpClient) {
		httpCommunicatorService.initializeConnection(httpClient);
	}

	public User register() throws ClientProtocolException, IOException {
		String response = httpCommunicatorService.register();
		return jsonDeserializerService.parseUser(response);
	}
	
	public PutResponse put(PutRequest putRequest) throws IOException {
		String json = jsonSerializerService.serializePutRequest(putRequest);
		String response = httpCommunicatorService.put(json);
		return jsonDeserializerService.parsePutResponse(response);
	}
	
	public IsMyTurnResponse isMyTurn(IsMyTurnRequest isMyTurnRequest) throws IOException {
		String json = jsonSerializerService.serializeIsMyTurnRequest(isMyTurnRequest);
		String response = httpCommunicatorService.isMyTurn(json);
		return jsonDeserializerService.parseIsMyTurnResponse(response);
	}
	
	public StatusResponse getStatus(StatusRequest request) throws ClientProtocolException, IOException {
		String json = jsonSerializerService.serializeStatusRequest(request);
		String response = httpCommunicatorService.getStatus(json);
		return jsonDeserializerService.parseStatusResponse(response);
	}
	
	public GameListResponse getGameList() throws ClientProtocolException, IOException {
		String response = httpCommunicatorService.getGameList();
		return jsonDeserializerService.parseGameListResponse(response);
	}
	
	public void closeConnection() {
		httpCommunicatorService.closeConnection();
	}

}
