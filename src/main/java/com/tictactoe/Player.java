package com.tictactoe;

import java.io.IOException;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;

import com.tictactoe.domain.User;
import com.tictactoe.http.HttpService;
import com.tictactoe.http.request.IsMyTurnRequest;
import com.tictactoe.http.request.PutRequest;
import com.tictactoe.http.response.IsMyTurnResponse;
import com.tictactoe.http.response.PutResponse;

public class Player extends TimerTask {

	private User user;
	private HttpService httpManagger;
	
	public Player(User user, HttpService httpManagger) {
		this.user = user;
		this.httpManagger = httpManagger;
	}


	@Override
	public void run() {
		try {
			IsMyTurnResponse isMyTurnResponse = httpManagger.isMyTurn(new IsMyTurnRequest(user.getUuid()));
			System.out.println(isMyTurnResponse);
			if (isMyTurnResponse.isMyTurn()) {
				PutResponse putResponse = httpManagger.put(new PutRequest(user.getUuid(), (int) (Math.random() * 50), (int) (Math.random() * 50)));
		    	System.out.println(putResponse);
			}
		} catch (ClientProtocolException e) {
			httpManagger.closeConnection();
		} catch (IOException e) {
			httpManagger.closeConnection();
		}
    	
	}

}
