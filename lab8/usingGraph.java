package lab8;

public class usingGraph {

	public static void main(String[] args) {
		// The class is not defined however, this class was made
		// to observe how to use the Graph interface
		//Instantiate a new graph, with directed edges
		Graph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		// u
		Vertex<String> u = graph.insertVertex("A");
		// v
		Vertex<String> v = graph.insertVertex("B");
		// vertex to get
		Vertex<String>target = null;
		// new edge between u and v
		graph.insertEdge(u, v, 1);
		Iterable<Vertex<String>> vertices = graph.vertices();
		// gets the Vertex with string A
		for(Vertex<String>vertex : vertices) {
			if(vertex.getElement().equals("A")) {
				target = vertex;
			}
		}
		System.out.println("Gets target vertex and prints its element.");
		// If the target vertex is not null, it prints its element
		if(target != null) System.out.println(target.getElement());
		
		@SuppressWarnings("rawtypes")
		Vertex[]endVertices = null;
		System.out.println("Outgoing edges of target vertex with element A.");
		// Gets all outgoing edges of target vertex
		Iterable<Edge<Integer>> outgoingOfTarget = graph.outgoingEdges(target);
		for(Edge<Integer> edge : outgoingOfTarget) {
			// Prints its elements
			System.out.println(edge.getElement());
			endVertices = graph.endVertices(edge);
		}
		
		System.out.println("End vertices of edge called 1.");
		// Prints all the endVertices of target's edge
		for(int i = 0; i < endVertices.length; i++) {
			System.out.println(endVertices[i].getElement());	
		}
	}

}
