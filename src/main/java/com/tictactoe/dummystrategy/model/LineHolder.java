package com.tictactoe.dummystrategy.model;

import java.util.HashMap;
import java.util.Map;

import com.tictactoe.domain.Element;
import com.tictactoe.dummystrategy.model.lineid.LineIdGenerator;

public class LineHolder {

	private LineIdGenerator lineIdGenerator;
	private Map<Integer, Line> lines;

	public LineHolder(LineIdGenerator lineIdGenerator) {
		this.lineIdGenerator = lineIdGenerator;
		lines = new HashMap<>();
	}

	public void add(Element element) {
		int id = lineIdGenerator.generateId(element);
		if (!lines.containsKey(id)) {
			lines.put(id, new Line());
		}
		lines.get(id).add(element);
	}
}
