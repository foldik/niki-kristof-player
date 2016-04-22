package com.tictactoe.json;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.tictactoe.domain.Element;

public class ElementDeserializer {
	
	public Element deserializeElement(String value){
		Gson reader = new GsonBuilder().create();
		return reader.fromJson(value, Element.class);
	}
	
	public List<Element> deserializeElements(String value) {
		Type listType = new TypeToken<List<Element>>() {}.getType();
        Gson googleJson = new Gson();
        List<Element> jsonObjList = googleJson.fromJson(((JsonObject)new JsonParser().parse(value)).get("data"), listType);
        return jsonObjList;
	}
}
