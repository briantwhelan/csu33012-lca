import java.util.HashSet;
/*************************************************************************
 *  {@code DirectedGraph} class.
 *  Adapted from Sedgewick and Wayne's Algorithms Textbook.
 *  @see <a href="https://algs4.cs.princeton.edu/">Algorithms Textbook</a>
 *
 *  @version 29/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DirectedGraph 
{
    private final int numberOfVertices;
    private int numberOfEdges;
    private HashSet<Integer>[] adjacencyLists;
    private int[] indegrees;

	/**
     * Creates an empty {@code DirectedGraph} with the specified number of vertices
     * @param numberOfVertices the number of vertices to be included in the {@code DirectedGraph}
     */
    public DirectedGraph(int numberOfVertices) throws IllegalArgumentException
    {
       if(numberOfVertices < 0)
		{
			throw new IllegalArgumentException("Number of vertices must be positive");
		}
		
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		
        this.adjacencyLists = (HashSet<Integer>[]) new HashSet[numberOfVertices];
		for(int vertex = 0; vertex < numberOfVertices; vertex++)
		{
			this.adjacencyLists[vertex] = new HashSet<Integer>();
		}

        this.indegrees = new int[numberOfVertices];
        for(int vertex = 0; vertex < numberOfVertices; vertex++)
		{
			this.indegrees[vertex] = 0;
		}
    }

	/**
     * Checks whether the specified vertex is a valid vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex to validate
     * @return {@code true} if {@code vertex} is valid and {@code false} otherwise
     */
    private boolean isValidVertex(int vertex)
    {
        return ((vertex >= 0) && (vertex < numberOfVertices));
    }

	/**
     * Adds the directed edge between the two specified vertices to the {@code DirectedGraph}
     * 
     * @param vertex1 the initial vertex of the edge to be added
     * @param vertex2 the terminal vertex of the edge to be added
     */
    public void addEdge(int vertex1, int vertex2)
    {
		if(isValidVertex(vertex1)
    		&& isValidVertex(vertex2)
    		&& (!adjacencyLists[vertex1].contains(vertex2)))
    	{
	    	adjacencyLists[vertex1].add(vertex2);
            indegrees[vertex2]++;
	    	numberOfEdges++;
    	}
    }

	/**
     * Gets the adjacency list for the specified vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex of which the adjacency list is required
     * @return the vertices adjacent to {@code vertex}
     */
    public Iterable<Integer> getAdjacencyList(int vertex)
    {
    	Iterable<Integer> adjacencyList = null;	
		if(isValidVertex(vertex))
    	{
    		adjacencyList = adjacencyLists[vertex];
    	}    
	
		return adjacencyList;
    }

	/**
     * Gets the outdegree of the specified vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex of which the outdegree is required
     * @return the outdegree of {@code vertex}
     */
    public int getOutdegree(int vertex)
    {
        int outdegree = -1;
        if(isValidVertex(vertex))
        {
            outdegree = adjacencyLists[vertex].size();
        }

        return outdegree;
    }

	/**
     * Gets the indegree of the specified vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex of which the indegree is required
     * @return the indegree of {@code vertex}
     */
    public int getIndegree(int vertex)
    {
        int indegree = -1;
        if(isValidVertex(vertex))
        {
            indegree = indegrees[vertex];
        }

        return indegree;
    }

	/**
     * Returns the Lowest Common Ancestor of the two specified vertices (if they exist) in the {@code DirectedGraph}.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the {@code int} corresponding to the Lowest Common Ancestor vertex of {@code vertex1} and {@code vertex2} (or {@code null} if no such vertex exists)
     */
    public int lowestCommonAncestor(int vertex1, int vertex2)
    {
        return 0;
    }

	 /**
     * Gets the number of vertices in the {@code DirectedGraph}
     * 
     * @return the number of vertices in the {@code DirectedGraph}
     */
    public int getNumberOfVertices()
    {
        return numberOfVertices;
    }

	 /**
     * Gets the number of edges in the {@code DirectedGraph}
     * 
     * @return the number of edges in the {@code DirectedGraph}
     */
    public int getNumberOfEdges()
    {
        return numberOfEdges;
    }

	/**
     * Gets the {@code String} representation of the {@code DirectedGraph}.
     * 
     * @return the {@code String} representation of the {@code DirectedGraph}
     */
	@Override
    public String toString()
    {
        String string =  getNumberOfVertices() + " vertices, " + getNumberOfEdges() + " edges\n";
	    for(int vertex = 0; vertex < numberOfVertices; vertex++)
	    {
		    string += vertex + ": ";
		    for(int adjacentVertex : getAdjacencyList(vertex))
		    {
		    	string += adjacentVertex + " ";
		    }
		    string += "\n";
	    }
	    
	    return string;
    }
}

