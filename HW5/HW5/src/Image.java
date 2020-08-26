/**
 * Simple class that holds 3 priority queue inside it.
 * One priority queue holds values with respect to lexical comparison.
 * Other priority queue holds values with respect to L2 norm values.
 * Other priority queue holds values with respect to Bitmix comparison.
 *
 * It also has remove and insert methods inside it.
 *
 */
public class Image {

    private PriorityQueue<Pixel> PQLEX;
    private PriorityQueue<Pixel> PQEUC;
    private PriorityQueue<Pixel> PQBMX;

    Pixel[][] pixelArray;
    private int lex_count=0;
    private int euc_count=0;
    private int bmx_count=0;

    /**
     * Simple constructor that takes the pixel array and creates the queues.
     * @param pixels Array.
     */
    public Image(Pixel[][] pixels){
        Lex_Comparator Lex = new Lex_Comparator();
        Euc_Comparator Euc = new Euc_Comparator();
        BMX_Comparator Bmx = new BMX_Comparator();
        PQLEX = new PriorityQueue<>(Lex);
        PQEUC = new PriorityQueue<>(Euc);
        PQBMX = new PriorityQueue<>(Bmx);

        pixelArray=pixels;
    }

    /**
     * Simple insert method for queues.
     * @param pixel Element which wanted to add.
     */
    public synchronized void insertQueues(Pixel pixel){

        PQLEX.offer(pixel);
        PQEUC.offer(pixel);
        PQBMX.offer(pixel);

        lex_count++;
        euc_count++;
        bmx_count++;

        notifyAll();

    }

    /**
     * Simple remove method. If index is 1 it deletes lex queue,
     * index is 2 deletes euc queue, index is 3 delete bmx queue.
     * @param number Index.
     * @return Removed item.
     */
    public synchronized Pixel remove(int number){
        if(number==1){
            while(lex_count==0){
                try {

                    wait();
                } catch (InterruptedException e) { }
            }

            lex_count--;
            notifyAll();
            return PQLEX.poll();
        }
        else if(number==2){
            while(euc_count==0){
                try {
                    wait();
                } catch (InterruptedException e) { }
            }

            euc_count--;
            notifyAll();
            return PQEUC.poll();
        }
        else if(number==3){
            while(bmx_count==0){
                try {
                    wait();
                } catch (InterruptedException e) { }
            }

            bmx_count--;
            notifyAll();
            return PQBMX.poll();
        }
        return null;
    }

}
