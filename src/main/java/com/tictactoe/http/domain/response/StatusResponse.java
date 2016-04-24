package com.tictactoe.http.domain.response;

import java.util.List;

import com.tictactoe.domain.Element;

public class StatusResponse {

	private List<Element> elements;

	public StatusResponse(List<Element> elements) {
		this.elements = elements;
	}

	public List<Element> getElements() {
		return elements;
	}

	@Override
	public String toString() {
		return "StatusResponse [elements=" + elements + "]";
	}

	
}
