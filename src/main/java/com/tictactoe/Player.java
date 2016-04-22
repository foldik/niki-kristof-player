package com.tictactoe;

import java.io.IOException;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;

import com.tictactoe.domain.IsMyTurnRequest;
import com.tictactoe.domain.IsMyTurnResponse;
import com.tictactoe.domain.PutRequest;
import com.tictactoe.domain.PutResponse;
import com.tictactoe.domain.User;
import com.tictactoe.http.HttpManagger;

public class Player extends TimerTask {

	private User user;
	private HttpManagger httpManagger;
	
	public Player(User user, HttpManagger httpManagger) {
		this.user = user;
		this.httpManagger = httpManagger;
	}


	@Override
	public void run() {
		try {
			IsMyTurnResponse isMyTurnResponse = httpManagger.isMyTurn(new IsMyTurnRequest(user.getUuid()));
			System.out.println(isMyTurnResponse);
			if (isMyTurnResponse.isMyTurn()) {
				PutResponse putResponse = httpManagger.put(new PutRequest(user.getUuid(), (int) (Math.random() * 1000000), (int) (Math.random() * 1000000)));
		    	System.out.println(putResponse);
			}
		} catch (ClientProtocolException e) {
			httpManagger.closeConnection();
		} catch (IOException e) {
			httpManagger.closeConnection();
		}
    	
	}

}
