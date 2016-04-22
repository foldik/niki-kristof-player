package com.tictactoe;

import java.io.IOException;
import java.util.Timer;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tictactoe.domain.User;
import com.tictactoe.http.HttpCommunicator;
import com.tictactoe.http.HttpManagger;
import com.tictactoe.http.HttpRequestCreator;
import com.tictactoe.http.HttpResponseProcessor;
import com.tictactoe.json.deserializer.ElementDeserializer;
import com.tictactoe.json.deserializer.IsMyTurnResponseDeserializer;
import com.tictactoe.json.deserializer.JsonDeserializer;
import com.tictactoe.json.deserializer.PutResponseDeserializer;
import com.tictactoe.json.deserializer.UserDeserializer;
import com.tictactoe.json.serializer.IsMyTurnRequestSerializer;
import com.tictactoe.json.serializer.JsonSerializer;
import com.tictactoe.json.serializer.PutRequestSerializer;

public class App 
{
    public static void main( String[] args )
    {
    	HttpManagger httpManagger = new HttpManagger(
    			new JsonDeserializer(
    					new UserDeserializer(), 
    					new ElementDeserializer(),
    					new PutResponseDeserializer(),
    					new IsMyTurnResponseDeserializer()),
    			new JsonSerializer(
    					new PutRequestSerializer(),
    					new IsMyTurnRequestSerializer()),
    			new HttpCommunicator(
    					new DefaultHttpClient(), 
    					new HttpRequestCreator("10.0.8.110", "8080"), 
    					new HttpResponseProcessor()));
    	
    	httpManagger.initializeConnection();
    	
    	User user;
		try {
			user = httpManagger.register();
			System.out.println(user);
	    	Timer timer = new Timer(false);
	    	timer.scheduleAtFixedRate(new Player(user, httpManagger), 0, 500);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
