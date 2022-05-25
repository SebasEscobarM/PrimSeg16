package model;

import java.util.Comparator;

public class NodeComparator<T> implements Comparator<Node<T>>{

	@Override
	public int compare(Node<T> o1, Node<T> o2) {
		return o1.getKey()-o2.getKey();
	}

}
