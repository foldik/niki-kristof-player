package com.tictactoe.dummystrategy.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.tictactoe.domain.Element;

public class Line {

	private TreeSet<SubLine> subLines;
	
	public Line() {
		subLines = new TreeSet<>(SubLineComparator.getInstance());
	}
	
	public void add(Element element) {
		
	}
	
	public List<SubLine> getSubLines() {
		return new ArrayList<>(subLines);
	}
	
	public static class SubLineComparator implements Comparator<SubLine> {
		
		public static SubLineComparator getInstance() {
			return InstanceHolder.INSTANCE;
		}

		@Override
		public int compare(SubLine subLine1, SubLine subLine2) {
			if (subLine1.hasCommonPart(subLine2)) {
				throw new IllegalStateException("Can not have common part is sumblimes");
			}
			return subLine1.compareTo(subLine2);
		}

		private static class InstanceHolder {
			public static final SubLineComparator INSTANCE = new SubLineComparator();
		}
	}
}
