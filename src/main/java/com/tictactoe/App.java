package com.tictactoe;

import com.tictactoe.http.HttpManagger;
import com.tictactoe.json.JsonManagger;
import com.tictactoe.json.UserDeserializer;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(new HttpManagger(new JsonManagger(new UserDeserializer())).register());
    }
}
