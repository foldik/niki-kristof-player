package com.tictactoe.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Component;

@Component
public class HttpResponseProcessor {
	
	public String getJsonContent(HttpResponse httpResponse) throws IOException {
		StringBuilder responseContent = new StringBuilder();
		if (httpResponse.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + httpResponse.getStatusLine().getStatusCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));
		String line;
		while ((line = br.readLine()) != null) {
			responseContent.append(line);
		}
		return responseContent.toString();
	}

}
