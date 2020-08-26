/**
 * Simple class that contains some mathematical operations.
 * @author Yusuf Can
 */
public class Math {

    /**
     * Calculates factorial of given number.
     * @param n Number.
     * @return Factorial.
     */
    public int factorial(int n){
        int i,result=1;
        for(i=1;i<=n;i++){
            result=result*i;
        }
        return result;
    }

    /**
     * Takes pow of given number.
     * @param x bottom.
     * @param n top.
     * @return Result of operation.
     */
    public int pow(int x, int n){
        int i;
        double result=1.0;
        for(i=1;i<=n;i++){
            result=result*x;
        }
        return ((int)result);
    }

    /**
     * Calculates sin of given number.
     * @param x_ Number.
     * @return Result of sin operation.
     */
    public double sin(double x_){


        if(x_ < 0){
            while(x_<0){
                x_+=360;
            }
        }

        if(x_ > 360){
            x_ = x_%360;
        }

        int sign =0;

        if(x_==90){
            return 1;
        }
        else if(x_ > 90 && x_ <=180){
            x_ = 180 - x_;
        }
        else if(x_>=180 && x_<=270){
            x_ = x_-180;
            sign++;
        }
        else if(x_>270 && x_<360){
            x_=360-x_;
            sign++;
        }

        double x = (x_*3.14)/180;

        /*If number is smaller than 1, we have to extend it with 100. */
        x=x*100;

        int term=15,counter=1,i;
        double result=0,answer;

        for(i=2;i<=term+1;i++){

            /*Appy the sinus with Taylor Expression.*/
            answer=pow(-1,i)*(pow((int)x,counter)/(pow(100,counter)*(double)factorial(counter)));
            result=(result+answer);
            counter=counter+2;
        }

        if(sign != 0 ){
            result *=(-1);
        }
        return result;
    }

    /**
     * Calculates cos of given number.
     * @param x_ Number.
     * @return sin(90-x_).
     */
    public double cos(double x_){
        return sin(90-x_);
    }

    /**
     * Takes the absolute value.
     * @param x Number.
     * @return Absolute value.
     */
    public double abs(double x){
        if(x<0)
            return (x*(-1));

        return x;
    }


}
