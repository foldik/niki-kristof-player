package com.tictactoe.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tictactoe.domain.User;
import com.tictactoe.json.JsonManagger;

public class HttpManagger {

	private JsonManagger jsonManagger;

	public HttpManagger(JsonManagger jsonManagger) {
		this.jsonManagger = jsonManagger;
	}

	public User register() {
		StringBuilder responseContent = new StringBuilder();
		User user = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet("http://10.0.8.254:8080/xoxo/reg");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String line;
			while ((line = br.readLine()) != null) {
				responseContent.append(line);
			}
			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonManagger.parseUser(responseContent.toString());
	}

}
