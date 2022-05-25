package model;

import org.junit.jupiter.api.Test;

class GraphTest {
	
	public static Graph<String> graph;
	
	public void setupStage() {
		graph=new Graph<>();
		graph.addVertex(new Node<String>("at"));
		graph.addVertex(new Node<String>("ch"));
		graph.addVertex(new Node<String>("sf"));
		graph.addVertex(new Node<String>("de"));
		graph.addVertex(new Node<String>("ny"));
		
		graph.addEdge("sf", "ny", 2000);
		graph.addEdge("sf", "ch", 1200);
		graph.addEdge("ch", "ny", 1000);
		graph.addEdge("ny", "at", 800);
		graph.addEdge("at", "ch", 700);
		graph.addEdge("ch", "de", 1300);
		graph.addEdge("de", "sf", 900);
		graph.addEdge("sf", "at", 2200);
		graph.addEdge("at", "de", 1400);
		graph.addEdge("de", "ny", 1600);
	}

	@Test
	void test() {
		setupStage();
		System.out.println(graph.prim("at"));
	}

}
