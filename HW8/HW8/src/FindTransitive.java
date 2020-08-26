public class FindTransitive {

    /**
     * Number of vertices.
     */
    private int vNum;

    /**
     * Graph.
     */
    private int graph[][];

    public FindTransitive(int vNum,int graph[][]){
        this.vNum = vNum;
        this.graph=graph;
    }


    /**
     * Transitive method that return new graph.
     * @param graph
     */
    public int[][] transitive(int graph[][])
    {
        int result[][] = new int[vNum][vNum];
        int  i, j, k;

        for (i = 0; i < vNum; i++) {
            for (j = 0; j < vNum; j++) {
                result[i][j] = graph[i][j];
            }
        }

        /*For middle vertices.*/
        for (k = 0; k < vNum; k++)
        {
            /*Takes all vertices first.*/
            for (i = 0; i < vNum; i++)
            {
                /*Takes all vertices again for the upper loop.*/
                for (j = 0; j < vNum; j++)
                {
                   /*Checks if k is between i and j.*/
                    result[i][j] =
                            (result[i][j]!=0) || ((result[i][k]!=0) && (result[k][j]!=0))?1:0;
                }
            }
        }

        return result;
    }
}
