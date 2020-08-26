import java.lang.Math;
import java.util.Comparator;

/**
 * Simple comparator class that compares its L2 norms.
 */
public class Euc_Comparator implements Comparator<Pixel> {

    /**
     * Simple compare class.
     * @param left Value 1.
     * @param right Value 2.
     * @return 1 if value1 > values, -1 if value2 > value1, 0 otherwise.
     */
    public int compare(Pixel left,Pixel right){

        double left_Euc = Math.sqrt( Math.pow(left.Red,2) + Math.pow(left.Green,2) + Math.pow(left.Blue,2) );
        double right_Euc = Math.sqrt( Math.pow(right.Red,2) + Math.pow(right.Green,2) + Math.pow(right.Blue,2) );

        if(left_Euc < right_Euc) return -1;
        else if(left_Euc > right_Euc) return 1;
        else return 0;
    }


}
