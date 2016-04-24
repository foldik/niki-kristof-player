package com.tictactoe;

import java.util.Timer;

import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tictactoe.config.AppConfig;
import com.tictactoe.dummystartegy.DummyStrategy;

public class App {
	
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	Player player = context.getBean(Player.class);
    	player.initializeConnection(new DefaultHttpClient());
    	player.setStrategy(new DummyStrategy());
    	player.register();
    	Timer timer = new Timer(false);
    	timer.scheduleAtFixedRate(player, 0, 500);
        
    }
}
