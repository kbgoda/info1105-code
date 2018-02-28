package lab8;
// import textbook.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TravelDestinations {

	private Graph<String, Integer> graph;
	Set<Vertex<String>> known;

	public TravelDestinations(Graph<String, Integer> graph) {
		this.graph = graph;
		this.known = new HashSet<Vertex<String>>();
	}

	/* Exercise 1 methods */

	/**
	 * Return all the countries that are a single direct flight away from the
	 * given country, in any order. If no flights depart this country, return an
	 * empty List.
	 */
	@SuppressWarnings("unchecked")
	public List<String> getDirectDestinations(String fromCountry) {
		ArrayList<String> countries = new ArrayList<String>();
		Vertex<String> from = null;
		// Get the other country vertices direct to this country vertex
		Iterable<Vertex<String>> vertices = graph.vertices();
		for(Vertex<String> vertex : vertices) {
			if(vertex.getElement().equals(fromCountry)) {
				from = vertex;
			}
		}
		// If the country is not in the graph, returns null
		if(from == null) return null;
		// All edges of fromCountry
		Iterable<Edge<Integer>> directEdges = this.graph.outgoingEdges(from);
		// All direct countries
		@SuppressWarnings("rawtypes")
		Vertex[]endVertices = null;
		// Loops through the directEdges of the fromCountry
		for(Edge<Integer> edge : directEdges) {
			endVertices = this.graph.endVertices(edge);
			// Loops through the array of countries and gets the country which is 
			// not fromCountry
			for(Vertex<String>vertex : endVertices) {
				if(!(vertex.getElement().equals(from.getElement()))) {
					countries.add(vertex.getElement());
				}
			}
		}
		return countries;
	}

	/**
	 * Return true if there is a direct flight from 'fromCountry' to
	 * 'toCountry'. Otherwise, return false.
	 */
	public boolean isDirectFlight(String fromCountry, String toCountry) {
		// Checks that both countries are in the graph
		Vertex<String> from = null;
		Vertex<String> to = null;
		Iterable<Vertex<String>> vertices = graph.vertices();
		for(Vertex<String> vertex : vertices) {
			if(vertex.getElement().equals(fromCountry)) {
				from = vertex;
			}
			if(vertex.getElement().equals(toCountry)) {
				to = vertex;
			}
		}
		if(to == null || from == null) return false;
		// If the vertices are not adjacent, they are not a direct flight
		if(graph.getEdge(from, to) != null) return true;
		return false;
	}
	
	// Algorithm to traverse the graph and get the reachable vertices using u
	public void DFS(Graph<String, Integer> g, 
			Vertex<String> u, 
			Set<Vertex<String>> known) {
		// Traverses outgoing edges of u
		for(Edge<Integer> e : g.outgoingEdges(u)) {
			Vertex<String> v = g.opposite(u, e);
			if(!known.contains(v)) {
				known.add(v);
				DFS(g, v, known);
			}
		}
	}
	
	/* Exercise 2 methods */
	/**
	 * Return all the countries that are reachable from the given country, using
	 * any number of flights (for example, if we can fly from A to B, then from
	 * B to C, then we can say that both B and C are reachable from A.
	 */
	public List<String> getReachableDestinations(String country) {
		ArrayList<String> countries = new ArrayList<String>();
		Vertex<String> reachable = null;
		// Checks that the country exists in the graph
		Iterable<Vertex<String>> vertices = graph.vertices();
		for(Vertex<String> vertex : vertices) {
			if(vertex.getElement().equals(country)) {
				reachable = vertex;
			}
		}
		// If country is not in ArrayList, then we return an empty list
		if(reachable == null) return countries;
		
		// If the vertex has no incoming degrees then we return null
		// This means that no people are able to come to the country
		if(this.graph.inDegree(reachable) == 0) return null; 
		
		// If the country exists, and we know that it has outgoing edges
		// then it is possible to get reachable destinations
		DFS(this.graph, reachable, this.known);
		for(Vertex<String>count : known) {
			// If the country is not the starting one, then it will be added
			// to a list of reachable countries
			if(!(count.getElement().equals(country))) {
				countries.add(count.getElement());
			}
		}
		// Clears the reachable destinations so that method can be reused for other countries
		known.clear();
		return countries;
	}

	/* Exercise 3 methods */

	/**
	 * Return the country ('destinationA' or 'destinationB') which requires
	 * fewer flights to travel to from country 'current'
	 */
	public String closerDestination(String current, String destinationA, String destinationB) {
		// TODO: implement this method
		return null;
	}
}
