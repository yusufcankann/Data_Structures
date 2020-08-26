import java.util.Iterator;

public interface Graph {

    /**
     * Gets the number of vertices.
     * @return Vertices number.
     */
    int getNumV();

    /**
     * Gets graph is directed or not.
     * @return True if graph is directed.
     */
    boolean isDirected();

    /**
     * Inserts edge.
     * @param edge Edge.
     */
    void insert(Edge edge);

    /**
     * İf there is edge exist or not.
     * @param source Source.
     * @param dest Destination.
     * @return True if there exist an edge.
     */
    boolean isEdge(int source, int dest);

    /**
     * Gets the edge.
     * @param source Source.
     * @param dest Destination.
     * @return Edge.
     */
    Edge getEdge(int source,int dest);

}
