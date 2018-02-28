package lab8;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class TravelDestinationsTest {

	@Test
	public void travelDestinations() {
		Graph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		Vertex<String> aust = graph.insertVertex("AU");
		Vertex<String> uk = graph.insertVertex("UK");
		graph.insertEdge(aust, uk, 1);
		
		TravelDestinations countryMap = new TravelDestinations(graph);
	}

}
