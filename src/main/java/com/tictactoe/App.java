package com.tictactoe;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tictactoe.http.HttpCommunicator;
import com.tictactoe.http.HttpManagger;
import com.tictactoe.http.HttpRequestCreator;
import com.tictactoe.http.HttpResponseProcessor;
import com.tictactoe.json.deserializer.ElementDeserializer;
import com.tictactoe.json.deserializer.JsonDeserializer;
import com.tictactoe.json.deserializer.PutResponseDeserializer;
import com.tictactoe.json.deserializer.UserDeserializer;

public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
    	HttpManagger httpManagger = new HttpManagger(
    			new JsonDeserializer(
    					new UserDeserializer(), 
    					new ElementDeserializer(),
    					new PutResponseDeserializer()), 
    			new HttpCommunicator(
    					new DefaultHttpClient(), 
    					new HttpRequestCreator("10.0.8.254", "8080"), 
    					new HttpResponseProcessor()));
    	
    	httpManagger.initializeConnection();
    	System.out.println(httpManagger.register());
        httpManagger.closeConnection();
    }
}
