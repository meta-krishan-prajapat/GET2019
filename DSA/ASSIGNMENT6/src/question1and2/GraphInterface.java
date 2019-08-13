package question1and2;

import java.util.List;

/**
 * @author krishan 
 * Interface to have operational methods
 */
public interface GraphInterface
{
	/**
	 * @return true if the nodes of the graph are connected
	 */
	boolean isConnected();

	/**
	 * @param node
	 * @return the nodes reachable from the specified node
	 */
	List<Integer> reachableNodes(int node);

	/**
	 * @return MST
	 */
	List<Edge> getMinimumSpanningTree();

	/**
	 * @param vertex1
	 * @param vertex2
	 * @return the shortest path between two vertex
	 */
	List<Integer> shortestPath(int vertex1, int vertex2);
}
