package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Graph<T> {
	
	private HashMap<T,Node<T>> nds;	
	public Graph() {
		nds=new HashMap<>();
	}
	
	public String prim(T r) {
		for(T i:nds.keySet()) {
			nds.get(i).setAnt(null);
			nds.get(i).setVis(false);
			nds.get(i).setKey(1000000000);
		}
		nds.get(r).setKey(0);
		PriorityQueue<Node<T>> q=new PriorityQueue<>(new NodeComparator<T>());
		for(T i:nds.keySet()) {
			q.add(nds.get(i));
		}
		while(!q.isEmpty()) {
			Node<T> u=q.peek();
			for(Edge<T> e:u.getEdg()) {
				if(!e.getTo().isVis() && e.getWeight()<e.getTo().getKey()) {
					e.getTo().setKey(e.getWeight());
					e.getTo().setAnt(u);
					q.add(e.getTo());
				}
			}
			u.setVis(true);
			q.remove(u);
		}
		String msg="";
		for(T i:nds.keySet()) {
			if(nds.get(i).getAnt()==null) {
				msg+="NULL --"+nds.get(i).getKey()+"--> "+nds.get(i).getItem()+"\n";
			}else {
				msg+=nds.get(i).getAnt().getItem()+"--"+nds.get(i).getKey()+"--> "+nds.get(i).getItem()+"\n";
			}
			
		}
		return msg;
	}
	
	public void addVertex(Node<T> nd) {
		if(nds.containsKey(nd.getItem())) {
			return;
		}
		nds.put(nd.getItem(), nd);
	}
	
	public void deleteVertex(T itm) {
		if(nds.isEmpty()) {
			return;
		}
		Node<T> nd=nds.get(itm);
		for(T i:nds.keySet()) {
			ArrayList<Edge<T>> toDel=new ArrayList<>();
			for(Edge<T> e: nds.get(i).getEdg()) {
				if(e.getTo()==nd) {
					toDel.add(e);
				}
			}
			nds.get(i).getEdg().removeAll(toDel);
		}
		nds.remove(itm);
	}
	
	public void addEdge(T nd1, T nd2, int w) {
		if(nds.get(nd1)!=null && nds.get(nd2)!=null) {
			nds.get(nd1).getEdg().add(new Edge<T>(nds.get(nd1), nds.get(nd2), w));
			nds.get(nd2).getEdg().add(new Edge<T>(nds.get(nd2), nds.get(nd1), w));
		}
	}
	
	public void deleteEdge(T nd1, T nd2, int w) {
		if(nds.get(nd1)!=null && nds.get(nd2)!=null) {
			for(Edge<T> e: nds.get(nd1).getEdg()) {
				if(e.getTo()==nds.get(nd2) && w==e.getWeight()) {
					nds.get(nd1).getEdg().remove(e);
					break;
				}
			}
			for(Edge<T> e: nds.get(nd2).getEdg()) {
				if(e.getTo()==nds.get(nd1) && w==e.getWeight()) {
					nds.get(nd2).getEdg().remove(e);
					break;
				}
			}
		}
	}
	
	public HashMap<T,Node<T>> getNds(){
		return nds;
	}
}
