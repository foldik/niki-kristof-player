package com.tictactoe.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpCommunicatorService {

	private HttpClient httpClient;
	private HttpRequestCreator httpRequestCreator;
	private HttpResponseProcessor httpResponseProcessor;

	@Autowired
	public HttpCommunicatorService(HttpRequestCreator httpRequestCreator,
			HttpResponseProcessor httpResponseProcessor) {
		this.httpRequestCreator = httpRequestCreator;
		this.httpResponseProcessor = httpResponseProcessor;
	}

	public void initializeConnection(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public String register() throws ClientProtocolException, IOException {
		HttpGet getRequest = httpRequestCreator.getRegisterRequest();
		HttpResponse response = httpClient.execute(getRequest);
		return httpResponseProcessor.getJsonContent(response);
	}

	public String put(String json) throws IOException {
		HttpPost request = httpRequestCreator.getPutRequest(json);
		HttpResponse response = httpClient.execute(request);
		return httpResponseProcessor.getJsonContent(response);
	}

	public String isMyTurn(String json) throws IOException {
		HttpPost request = httpRequestCreator.getIsMyTurnRequest(json);
		HttpResponse response = httpClient.execute(request);
		return httpResponseProcessor.getJsonContent(response);
	}

	public String getStatus(String json) throws ClientProtocolException, IOException {
		HttpPost request = httpRequestCreator.getStatusRequest(json);
		HttpResponse response = httpClient.execute(request);
		return httpResponseProcessor.getJsonContent(response);
	}

	public String getGameList() throws ClientProtocolException, IOException {
		HttpGet request = httpRequestCreator.getGameListRequest();
		HttpResponse response = httpClient.execute(request);
		return httpResponseProcessor.getJsonContent(response);
	}

	public void closeConnection() {
		if (httpClient != null) {
			httpClient.getConnectionManager().shutdown();
		}

	}

}
