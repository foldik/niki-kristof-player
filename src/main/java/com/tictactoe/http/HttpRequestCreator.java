package com.tictactoe.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class HttpRequestCreator {

	private static final String HTTP = "http://";
	private static final String XOXO = "/xoxo/";
	private static final String COLON = ":";
	
	private static final String REG = "reg";
	private static final String PUT = "put";
	private static final String IS_MY_TURN = "ismyturn";
	private static final String GAME_LIST = "gamelist";

	private String ip;
	private String port;

	public HttpRequestCreator(String ip, String port) {
		this.ip = ip;
		this.port = port;
	}

	public HttpGet getRegisterRequest() {
		String getUrl = createUrl(REG);
		return getRequest(getUrl);
	}
	
	public HttpPost getPutRequest(String params) throws UnsupportedEncodingException {
		String putUrl = createUrl(PUT);
		return getPostRequest(putUrl, params);
	}
	
	public HttpPost getIsMyTurnRequest(String params) throws UnsupportedEncodingException {
		String putUrl = createUrl(IS_MY_TURN);
		return getPostRequest(putUrl, params);
	}
	
	public HttpGet getGameListRequest() {
		String gameListUrl = createUrl(GAME_LIST);
		return getRequest(gameListUrl);
	}
	
	private String createUrl(String path) {
		return HTTP + ip + COLON + port + XOXO + path;
	}
	
	private HttpGet getRequest(String url) {
		HttpGet request = new HttpGet(url);
		request.addHeader("accept", "application/json");
		return request;
	}
	
	private HttpPost getPostRequest(String url, String params) throws UnsupportedEncodingException {
		HttpPost request = new HttpPost(url);
		request.addHeader("accept", "application/json");
		request.setEntity(new StringEntity(params));
		return request;
	}
}
