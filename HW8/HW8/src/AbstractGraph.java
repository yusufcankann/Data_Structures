public abstract class AbstractGraph implements Graph{

    /**
     * Vertices number.
     */
    protected int numV;

    /**
     * Directed or not.
     */
    private boolean directed;

    /**
     * Simple constructor that sets numver of vertices and directed.
     * @param numV Number of vertices.
     * @param directed Directed.
     */
    public AbstractGraph(int numV,boolean directed){
        this.numV = numV;
        this.directed = directed;
    }

    /**
     * Getter method for number of vertices.
     * @return Number of vertices.
     */
    public int getNumV(){
        return numV;
    }

    /**
     * Getter method for directed.
     * @return True if graph is directed.
     */
    public boolean isDirected(){
        return directed;
    }


}
