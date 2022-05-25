package model;

import java.util.ArrayList;
import java.util.List;

public class Node<T>{

	private T item;
	private List<Edge<T>> edg;
	private boolean vis;
	private Node<T> ant;
	private int key;
	
	public Node(T item){
		this.item=item;
		this.edg=new ArrayList<>(); 
		this.setVis(false);
		this.ant=null;
		this.setKey(1000000000);
	}
	
	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	public List<Edge<T>> getEdg() {
		return edg;
	}

	public boolean isVis() {
		return vis;
	}

	public void setVis(boolean vis) {
		this.vis = vis;
	}

	public Node<T> getAnt() {
		return ant;
	}

	public void setAnt(Node<T> ant) {
		this.ant = ant;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
