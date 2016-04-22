package com.tictactoe;

import java.io.IOException;
import java.util.Timer;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tictactoe.config.AppConfig;
import com.tictactoe.domain.User;
import com.tictactoe.http.HttpService;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	HttpService httpManagger = context.getBean(HttpService.class);
    	httpManagger.initializeConnection(new DefaultHttpClient());
    	
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
