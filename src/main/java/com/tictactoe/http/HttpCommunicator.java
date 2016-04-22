package com.tictactoe.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpCommunicator {

	private DefaultHttpClient httpClient;
	private HttpRequestCreator httpRequestCreator;
	private HttpResponseProcessor httpResponseProcessor;

	public HttpCommunicator(DefaultHttpClient httpClient, HttpRequestCreator httpRequestMaker, HttpResponseProcessor httpResponseProcessor) {
		this.httpClient = httpClient;
		this.httpRequestCreator = httpRequestMaker;
		this.httpResponseProcessor = httpResponseProcessor;
	}

	public void initializeConnection() {
		httpClient = new DefaultHttpClient();
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
	
	public String listGame() throws ClientProtocolException, IOException {
		HttpGet getRequest = httpRequestCreator.getGameListRequest();
		HttpResponse response = httpClient.execute(getRequest);
		return httpResponseProcessor.getJsonContent(response);
	}

	public void closeConnection() {
		if (httpClient != null) {
			httpClient.getConnectionManager().shutdown();
		}

	}

}
