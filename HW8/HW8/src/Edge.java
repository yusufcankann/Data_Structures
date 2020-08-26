public class Edge {

    /**
     * Destination.
     */
    private int dest;

    /**
     * Source;
     */
    private int source;

    /**
     * Weight;
     */
    private double weight;

    /**
     * Simple constructor that sets source and destination.
     * @param source Source.
     * @param dest Destination.
     */
    public Edge(int source,int dest){
        this.dest = dest;
        this.source = source;
    }

    /**
     * Simple constructor that sets source, destination and weight..
     * @param source Source.
     * @param dest Destinationc
     * @param w Weight.
     */
    public Edge(int source,int dest,double w){
        this.dest = dest;
        this.source = source;
        this.weight=w;
    }

    /**
     * Check given edge is equal or not. The weight is not considered.
     * @param o Edge.
     * @return True if equals.
     */
    public boolean equals(Object o){
        return ((Edge)o).getDest() == this.dest &&
                ((Edge)o).getSource() == this.source;
    }

    /**
     * Getter method for destination.
     * @return Destination.
     */
    public int getDest(){
        return dest;
    }

    /**
     * Getter method for source.
     * @return source.
     */
    public int getSource(){
        return source;
    }

    /**
     * Getter method for weight.
     * @return weight.
     */
    public double getWeight(){
        return weight;
    }


}
