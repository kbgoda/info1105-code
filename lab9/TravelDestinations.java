package lab9;

import java.util.List;
import java.util.*;

import lab9.textbook.*;

public class TravelDestinations {

	private Graph<String, Integer> graph;

	public TravelDestinations(Graph<String, Integer> graph) {
		this.graph = graph;
	}

	/* Exercise 1 methods */

	/**
	 * Return all the countries that are a single direct flight away from the
	 * given country, in any order. If no flights depart this country, return an
	 * empty List.
	 */
	public List<String> getDirectDestinations(String fromCountry) {
		if(fromCountry == null)
			return new ArrayList<String>();
		
		Vertex<String> result = getVertexFromCountry(fromCountry);
		
		if(result == null)
			return new ArrayList<String>();
		
		Iterable<Edge<Integer>> edges = graph.outgoingEdges(result);
		
		List<String> direct = new ArrayList<String>();
		
		for(Edge<Integer> edge : edges){
			Vertex<String>[] v = graph.endVertices(edge);
			String destination = v[1].getElement();
			direct.add(destination);
		}
		
		return direct;
	}

	/**
	 * Return true if there is a direct flight from 'fromCountry' to
	 * 'toCountry'. Otherwise, return false.
	 */
	public boolean isDirectFlight(String fromCountry, String toCountry) {
		if(fromCountry == null || toCountry == null){
			return false;
		}
		
		Vertex<String> result = getVertexFromCountry(fromCountry);
		
		if(result == null)
			return false;
		
		Iterable<Edge<Integer>> flights = graph.outgoingEdges(result);
		
		for(Edge<Integer> edge : flights){
			Vertex<String>[] vs = graph.endVertices(edge);
			if(vs[1].getElement().equals(toCountry)){
				return true;
			}
		}
		
		return false;
	}
	
	public Vertex<String> getVertexFromCountry(String country){
		Iterable<Vertex<String>> vertices = graph.vertices();
		
		Vertex<String> result = null;
		
		for(Vertex<String> vertex : vertices){
			if(vertex.getElement().equals(country)){
				result = vertex;
			}
		}
		
		return result;
	}

	/* Exercise 2 methods */
	/**
	 * Return all the countries that are reachable from the given country, using
	 * any number of flights (for example, if we can fly from A to B, then from
	 * B to C, then we can say that both B and C are reachable from A.
	 */
	public List<String> getReachableDestinations(String fromCountry) {
		Set<String> reachable = new HashSet<String>();
		
		this.DFS(fromCountry,fromCountry, reachable);
		return new ArrayList<String>(reachable);
	}
	
	public void DFS(String sourceCountry, String fromCountry, Set<String> reachable){
		if(fromCountry != sourceCountry){
			reachable.add(fromCountry);
		}
		for(String country : this.getDirectDestinations(fromCountry)){
			if(!reachable.contains(country) && country != sourceCountry){
				this.DFS(sourceCountry,country, reachable);
			}
		}
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
	
	/**
	 * Return the cheapest direct flight in the graph
	 *
	 */
	public String cheapestDirectFlight(String fromCountry){
		Vertex<String> v = getVertexFromCountry(fromCountry);
		
		if(v == null)
			return null;
		
		Iterable<Edge<Integer>> edges = graph.outgoingEdges(v);
		
		Integer lowest = null;
		String lowestCountry = null;
		
		for(Edge<Integer> edge : edges){
			if(lowest == null){
				lowest = edge.getElement();
			}
			
			Integer edgeVal = edge.getElement();
			
			if(edgeVal <= lowest){
				lowest = edgeVal;
				lowestCountry = graph.endVertices(edge)[1].getElement();
			}
		}
		
		return lowestCountry;
	}
	
	/** 
     *  Return the minimal cost to get to toCountry from fromCountry
     *  If fromCountry cannot be reached, then return Integer.MAX_VALUE
     *  Implement using Djikstra's with optimisations
     */  
    public int shortestPathCost(String fromCountry, String toCountry) {
        HashMap<Vertex<String>, Integer> distances = shortestPaths(fromCountry);
        
        Vertex<String> v = getVertexFromCountry(toCountry);
        
        return distances.get(v);
    }
    
    public HashMap<Vertex<String>,Integer> shortestPaths(String fromCountry){
    	HashMap<Vertex<String>, Integer> distances = initialiseDistances(fromCountry);
    	
    	PriorityQueue<MySimpleEntry> queue = new PriorityQueue<MySimpleEntry>(new MySimpleEntry());
    	
    	for(java.util.Map.Entry<Vertex<String>, Integer> entry : distances.entrySet()){
    		queue.add(new MySimpleEntry(entry.getValue(),entry.getKey()));
    	}
    	
    	while(queue.size() > 0){
    		Vertex<String> u = queue.remove().getValue();
    		
    		Object[] queueEntries = queue.toArray();
    		
    		for(Object e : queueEntries){
    			MySimpleEntry entry = (MySimpleEntry) e;
    			Edge<Integer> edge = graph.getEdge(u, entry.getValue());
    			
    			if(edge != null){
    				if(distances.get(u) + edge.getElement() < distances.get(entry.getValue())){
    					Integer newDistance = distances.get(u) + edge.getElement();
    					Vertex<String> v = entry.getValue();
    					distances.put(entry.getValue(), distances.get(u) + edge.getElement());
    					
    					queue.remove(entry);
    					queue.add(new MySimpleEntry(newDistance,v));
    				}
    			}
    		}
    	}
    	
    	return distances;
    }
    
    private class MySimpleEntry implements Comparator<MySimpleEntry> {
		
		private final Integer key;
		private final Vertex<String> value;
		
		public MySimpleEntry(){
			key = null;
			value = null;
		};
		
		MySimpleEntry(Integer key, Vertex<String> value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public int compare(MySimpleEntry a, MySimpleEntry b){
			return a.getKey() - b.getKey();
		}

		public Integer getKey() { return key; }
		
		public Vertex<String> getValue() { return value; }
	}

	private HashMap<Vertex<String>, Integer> initialiseDistances(String fromCountry) {
		HashMap<Vertex<String>, Integer> distances = new HashMap<Vertex<String>, Integer>();
    	
    	Iterable<Vertex<String>> vs = graph.vertices();
    	
    	for(Vertex<String> v : vs){
    		if(v.getElement().equals(fromCountry)){
    			distances.put(v, 0);
    		} else {
    			distances.put(v, Integer.MAX_VALUE);
    		}
    	}
    	
    	return distances;
	}
}
