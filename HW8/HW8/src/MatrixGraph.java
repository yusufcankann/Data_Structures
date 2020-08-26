import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {

    /**
     * Edge matrix.
     */
    private int edges[][];

    /**
     * Simple constructor that sets number of vertices and directed value
     * and creates edge matrix.
     * @param numV
     * @param directed
     */
    public MatrixGraph(int numV,boolean directed){
        super(numV,directed);
        edges = new int[numV][numV];

        for(int i=0;i<numV;i++){
            for(int j=0;j<numV;j++){
                edges[i][j]=0;
            }
        }
    }

    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()][edge.getDest()]=1;

        if(isDirected()){
                edges[edge.getDest()][edge.getSource()]=1;
        }
    }

    /**
     * Overrided insert method that takes source and destination.
     * @param source Source.
     * @param destination Destination.
     */
    public void insert(int source,int destination){
        edges[source][destination]=1;

        if(isDirected()){
            edges[destination][source]=1;
        }
    }

    @Override
    public boolean isEdge(int source, int dest) {
        return edges[source][dest] == 1;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        return new Edge(source,dest);
    }



    //I implement this method for testing the graph.
    /**
     * Prints graph matrix on the screen.
     */
    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j <numV ; j++) {
                System.out.print(edges[i][j]+ " ");
            }
            System.out.println();
        }
    }

    /**
     * Check transitive rule for every vertex and applies it into the graph(matrix).
     */
    public void applyTransitive() {
        FindTransitive ft = new FindTransitive(this.getNumV(),edges);
        edges=ft.transitive(edges);
    }

    public int countPopular(){
        int result = 0;
        int counter=0;

        for(int i=0;i<numV;i++){
            for(int j=0;j<numV;j++){
                if(edges[j][i]==1 && j!=i){
                    counter++;
                }
            }

            if(counter == numV-1) result++;
            counter=0;
        }

        return result;
    }
}