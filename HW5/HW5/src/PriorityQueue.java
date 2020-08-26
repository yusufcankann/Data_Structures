import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<E> {

    /**
     * Data
     */
    private ArrayList<E> data;

    /**
     * Comparator reference.
     */
    private Comparator<E> comparator = null;

    /**
     * Simple constructor that sets the comparator.
     * @param comp Comparator.
     */
    public PriorityQueue(Comparator comp){
        data = new ArrayList<>();
        comparator = comp;
    }

    /**
     * Inserts an item into the queue.
     * @param item Value.
     * @return True if it is succesfull.
     */
    public boolean offer(E item){
        data.add(item);
        int value = data.size()-1;
        int parent = (value-1)/2;

        while(parent>=0 && comparator.compare(data.get(parent),data.get(value)) < 0){

            swap(parent,value);
            value=parent;
            parent=(value-1)/2;
        }
        return true;
    }

    /**
     * Removes the smallest entry into the queue.
     * @return Removed entry.
     * @throws NoSuchElementException If queue is empty.
     */
    public E remove()
        throws NoSuchElementException {

        if(data.isEmpty()){
            throw new NoSuchElementException();
        }
         return this.poll();
    }

    /**
     * Removes the smallest entry into the queue.
     * @return Removed entry. Null if queue is empty.
     */
    public E poll(){

        if(data.isEmpty()){
            return null;
        }

        E element= data.get(0);

        if(data.size() == 1){
            data.remove(0);
            return element;
        }

        E lastItem = data.remove(data.size()-1);
        data.set(0,lastItem);
        int parent =0;

        boolean set_tree=true;

        while(set_tree==true){

            int leftChild = 2*parent+1;

            if(leftChild < data.size()){

                int rightChild = leftChild+1;
                int minChild = leftChild;

                if(rightChild < data.size() && compare(leftChild,rightChild) < 0 ) {
                    minChild = rightChild;
                }

                if (compare(parent, minChild) < 0) {
                    this.swap(parent, minChild);
                    /*Sets the index of element.*/
                    parent = minChild;
                } else set_tree = false;
            }
            else set_tree=false;
        }
        return element;
    }

    /**
     * Returns the smallest entry without removing it.
     * @return Null if queue is empty.
     */
    public E peek(){
        if(data.isEmpty() == true) return null;
        else return data.get(0);
    }

    /**
     * Returns the smallest entry without removeing it.
     * @return Entry.
     * @throws NoSuchElementException Throws if queue is empty.
     */
    public E element()
        throws NoSuchElementException{
        if(data.isEmpty() == true)
            throw new NoSuchElementException();

        return this.peek();
    }

    /**
     * Simple compare method.
     * @param a Index 1.
     * @param b Index 2.
     * @return 1 if value 1 is bigger than value 2, -1 if small, 0 otherwise.
     */
    public int compare(int a,int b){
        if(comparator.compare(data.get(a),data.get(b)) > 0) return 1;
        else if(comparator.compare(data.get(a),data.get(b)) == 0) return 0;
        else return -1;
    }

    /**
     * Swap given indexes.
     * @param a Index 1.
     * @param b Index 2.
     */
    public void swap(int a,int b){
        E temp = data.get(a);
        data.set(a,data.get(b));
        data.set(b,temp);
    }

}
