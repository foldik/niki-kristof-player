package com.tictactoe.jsonparser;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.tictactoe.domain.Element;

public class ElementParser {
	
	public Element parse(String value){
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(value, Element.class);
	}
	
	public List<Element> parseList(String value) {
		Type listType = new TypeToken<List<Element>>() {}.getType();
        Gson googleJson = new Gson();
        List<Element> jsonObjList = googleJson.fromJson(((JsonObject)new JsonParser().parse(value)).get("data"), listType);
        return jsonObjList;
	}
}
