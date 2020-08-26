import java.lang.Math;
import java.util.Comparator;

/**
 * Simple comparator class that makes bitmix comparison.
 */
public class BMX_Comparator implements Comparator<Pixel>{

    /**
     * Compae method.
     * @param px1 Value 1.
     * @param px2 Value 2.
     * @return 1 if value1 > values, -1 if value2 > value1, 0 otherwise.
     */
    public int compare(Pixel px1,Pixel px2){

        double px1sum1=0;
        double px1sum2=0;
        double px1_result=0;
        int pixel1_red=px1.Red;
        int pixel1_green=px1.Green;
        int pixel1_blue=px1.Blue;

        double px2sum1=0;
        double px2sum2=0;
        double px2_result=0;
        int pixel2_red=px2.Red;
        int pixel2_green=px2.Green;
        int pixel2_blue=px2.Blue;


        for(int i=1;i<=8;i++){

            for(int j=1;j<=3;j++){
                if(j==1){
                    px1sum2 = ( Math.pow(2,3-j) ) * ((pixel1_red >> (i)) & 1);
                    px2sum2 = ( Math.pow(2,3-j) ) * ((pixel2_red >> (i)) & 1);
                }
                else if(j==2){
                    px1sum2 = ( Math.pow(2,3-j) ) * ((pixel1_green >> (i)) & 1);
                    px2sum2 = ( Math.pow(2,3-j) ) * ((pixel2_green >> (i)) & 1);
                }
                else{
                    px1sum2 = ( Math.pow(2,3-j) ) * ((pixel1_blue >> (i)) & 1);
                    px2sum2 = ( Math.pow(2,3-j) ) * ((pixel2_blue >> (i)) & 1);
                }
            }

            px1sum1 = Math.pow(2,3*(8-i) );
            px1_result += px1sum1*px1sum2;

            px2sum1 = Math.pow(2,3*(8-i) );
            px2_result += px2sum1*px2sum2;
        }

        if(px1_result > px2_result) return 1;
        else if(px1_result < px2_result) return -1;
        else return 0;

    }
}
