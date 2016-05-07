package com.tictactoe.dummystrategy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubLine implements Comparable<SubLine> {

	private int startIndex;
	private int endIndex;
	private String character;

	public SubLine(int startIndex, int endIndex, String character) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.character = character;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public String getCharacter() {
		return character;
	}

	public SubLine merge(SubLine subLine2) {
		if (!character.equals(subLine2.getCharacter())) {
			throw new IllegalArgumentException("Subline with different character can't merge");
		}
		SubLine result;
		if (this.compareTo(subLine2) < 0) {
			result = new SubLine(startIndex, subLine2.getEndIndex(), character);
		} else if (this.compareTo(subLine2) > 0) {
			result = new SubLine(subLine2.getStartIndex(), endIndex, character);
		} else {
			result = new SubLine(startIndex, subLine2.getEndIndex(), character);
		}
		return result;
	}

	public List<SubLine> cut(int index) {
		List<SubLine> resultLines;
		if (index < startIndex || index > endIndex || startIndex == endIndex) {
			resultLines = new ArrayList<>();
		} else if (startIndex == index) {
			resultLines = Arrays.asList(new SubLine(index + 1, endIndex, character));
		} else if (endIndex == index) {
			resultLines = Arrays.asList(new SubLine(startIndex, endIndex - 1, character));
		} else {
			resultLines = Arrays.asList(new SubLine(startIndex, index - 1, character),
					new SubLine(index + 1, endIndex, character));
		}
		return resultLines;
	}
	
	public boolean hasCommonPart(SubLine other) {
		return (startIndex < other.getStartIndex() && endIndex > other.getStartIndex()) ||
				(startIndex < other.getEndIndex() && endIndex > other.getEndIndex());
	}

	@Override
	public int compareTo(SubLine o) {
		return startIndex - o.getStartIndex();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + endIndex;
		result = prime * result + startIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubLine other = (SubLine) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (endIndex != other.endIndex)
			return false;
		if (startIndex != other.startIndex)
			return false;
		return true;
	}

}
