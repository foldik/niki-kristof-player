package com.tictactoe.http;

import org.apache.http.client.methods.HttpGet;

public class HttpRequestCreator {

	private static final String HTTP = "http://";
	private static final String XOXO = "/xoxo/";
	private static final String COLON = ":";
	
	private static final String REG = "reg";
	private static final String GAME_LIST = "gamelist";

	private String ip;
	private String port;

	public HttpRequestCreator(String ip, String port) {
		this.ip = ip;
		this.port = port;
	}

	public HttpGet getRegisterRequest() {
		String getUrl = HTTP + ip + COLON + port + XOXO + REG;
		return getRequest(getUrl);
	}
	
	public HttpGet getGameListRequest() {
		String getUrl = HTTP + ip + COLON + port + XOXO + GAME_LIST;
		return getRequest(getUrl);
	}
	
	private HttpGet getRequest(String url) {
		HttpGet request = new HttpGet(url);
		request.addHeader("accept", "application/json");
		return request;
	}

}
