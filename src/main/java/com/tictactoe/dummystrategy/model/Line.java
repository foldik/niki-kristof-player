package com.tictactoe.dummystrategy.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.tictactoe.domain.Element;

public class Line {

	private TreeSet<Element> elements;
	
	public Line() {
		elements = new TreeSet<>(ElementComparator.getInstance());
	}
	
	public void add(Element element) {
		elements.add(element);
	}
	
	public List<Element> getElements() {
		return new ArrayList<>(elements);
	}
	
	public static class ElementComparator implements Comparator<Element> {
		
		public static ElementComparator getInstance() {
			return InstanceHolder.INSATENCE;
		}

		@Override
		public int compare(Element element1, Element element2) {
			int yDistance = element1.getY() - element2.getY();
			if (yDistance != 0) {
				return yDistance;
			} else {
				return element1.getX() - element2.getX();
			}
		}

		private static class InstanceHolder {
			public static final ElementComparator INSATENCE = new ElementComparator();
		}
	}
}
