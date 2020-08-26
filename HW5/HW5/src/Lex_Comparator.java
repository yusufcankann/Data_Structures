import java.util.Comparator;

/**
 * Simple comparator class class that makes standard lexicographical comparison.
 */
public class Lex_Comparator implements Comparator<Pixel> {

    /**
     * Simple comparator.
     * @param left Value 1.
     * @param right Value 2.
     * @return 1 if value1 > values, -1 if value2 > value1, 0 otherwise.
     */
    public int compare(Pixel left, Pixel right){

        if(left.Red < right.Red){
            return -1;
        }
        else if(left.Red == right.Red && left.Green < right.Green){
            return -1;
        }
        else if(left.Red == right.Red && left.Green == right.Green && left.Blue < right.Blue){
            return -1;
        }
        else if(left.Red == right.Red && left.Green == right.Green && left.Blue == right.Blue){
            return 0;
        }
        else return 1;
    }

}
