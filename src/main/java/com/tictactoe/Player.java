package com.tictactoe;

import java.io.IOException;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tictactoe.domain.Coordinate;
import com.tictactoe.domain.User;
import com.tictactoe.http.GameService;
import com.tictactoe.http.domain.request.IsMyTurnRequest;
import com.tictactoe.http.domain.request.PutRequest;
import com.tictactoe.http.domain.request.RegistrationRequest;
import com.tictactoe.http.domain.request.StatusRequest;
import com.tictactoe.http.domain.response.GameListResponse;
import com.tictactoe.http.domain.response.IsMyTurnResponse;
import com.tictactoe.http.domain.response.PutResponse;
import com.tictactoe.http.domain.response.RegistrationResponse;
import com.tictactoe.http.domain.response.StatusResponse;

import strategy.Strategy;

@Component
public class Player extends TimerTask {
	
	private static final Logger logger = LoggerFactory.getLogger(Player.class);

	private User user;
	private Strategy strategy;
	private GameService gameService;
	
	@Autowired
	public Player(GameService gameService) {
		this.gameService = gameService;
	}
	
	public void initializeConnection(HttpClient httpClient) {
		gameService.initializeConnection(httpClient);
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void register(String playerName) {
		logger.info("Registering");
		try {
			RegistrationResponse registrationResponse = gameService.register(new RegistrationRequest(playerName));
			user = new User();
			user.setName(playerName);
			user.setUuid(registrationResponse.getUuid());
			user.setGameId(registrationResponse.getGameId());
			user.setType(registrationResponse.getType());
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
			getGameList();
			IsMyTurnResponse isMyTurnResponse = checkIsMyTurn();
			if (isMyTurnResponse.isMyTurn()) {
				StatusResponse statusResponse = getStatus();
				put(statusResponse);
			}
		} catch (ClientProtocolException e) {
			destroyTask(e);
		} catch (IOException e) {
			destroyTask(e);
		}
    	
	}
	
	private void getGameList() throws ClientProtocolException, IOException {
		logger.info("Get game list");
		GameListResponse gameListResponse = gameService.getGameList();
		logger.info("Game list: {}", gameListResponse);		
	}

	private IsMyTurnResponse checkIsMyTurn() throws IOException {
		logger.info("Check is my turn");
		IsMyTurnResponse isMyTurnResponse = gameService.isMyTurn(new IsMyTurnRequest(user.getUuid()));
		logger.info("Is my trun response: {}", isMyTurnResponse);
		return isMyTurnResponse;
	}
	
	private StatusResponse getStatus() throws ClientProtocolException, IOException {
		logger.info("Get status");
		StatusResponse statusResponse = gameService.getStatus(new StatusRequest(user.getGameId()));
		logger.info("Status: {}", statusResponse);
		return statusResponse;
	}
	
	private void put(StatusResponse statusResponse) throws IOException {
		Coordinate coordinate = strategy.nextMove(statusResponse.getElements());
		PutRequest putRequest = new PutRequest(user.getUuid(), coordinate.getX(), coordinate.getY());
		logger.info("Put request: {}", putRequest);
		PutResponse putResponse = gameService.put(putRequest);
		logger.info("Put response: {}", putResponse);
	}
	
	private void destroyTask(IOException ioException) {
		logger.info(ioException.getMessage());
		logger.info("Close connection");
		gameService.closeConnection();
		cancel();
	}

}
