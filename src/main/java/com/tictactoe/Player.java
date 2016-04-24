package com.tictactoe;

import java.io.IOException;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tictactoe.domain.User;
import com.tictactoe.http.HttpService;
import com.tictactoe.http.request.IsMyTurnRequest;
import com.tictactoe.http.request.PutRequest;
import com.tictactoe.http.response.IsMyTurnResponse;
import com.tictactoe.http.response.PutResponse;

@Component
public class Player extends TimerTask {
	
	private static final Logger logger = LoggerFactory.getLogger(Player.class);

	private User user;
	private HttpService httpManagger;
	
	@Autowired
	public Player(HttpService httpManagger) {
		this.httpManagger = httpManagger;
	}
	
	public void initializeConnection(HttpClient httpClient) {
		httpManagger.initializeConnection(httpClient);
	}

	public void register() {
		logger.info("Registering");
		try {
			user = httpManagger.register();
		} catch (ClientProtocolException e) {
			destroyTask(e);
		} catch (IOException e) {
			destroyTask(e);
		}
		logger.info("Registered with user: {}", user);
	}

	@Override
	public void run() {
		try {
			IsMyTurnResponse isMyTurnResponse = checkIsMyTurn();
			if (isMyTurnResponse.isMyTurn()) {
				put();
			}
		} catch (ClientProtocolException e) {
			destroyTask(e);
		} catch (IOException e) {
			destroyTask(e);
		}
    	
	}
	
	private IsMyTurnResponse checkIsMyTurn() throws IOException {
		logger.info("Check is my turn");
		IsMyTurnResponse isMyTurnResponse = httpManagger.isMyTurn(new IsMyTurnRequest(user.getUuid()));
		logger.info("Is my trun response: {}", isMyTurnResponse);
		return isMyTurnResponse;
	}
	
	private void put() throws IOException {
		logger.info("Put");
		PutResponse putResponse = httpManagger.put(new PutRequest(user.getUuid(), (int) (Math.random() * 50), (int) (Math.random() * 50)));
		logger.info("Put response: {}", putResponse);
	}
	
	private void destroyTask(IOException ioException) {
		logger.info(ioException.getMessage());
		logger.info("Close connection");
		httpManagger.closeConnection();
		cancel();
	}

}
