import java.util.Iterator;

/**
 * Simple class that iterates normal array with spiral way.
 */
public class SpiralIterator implements Iterator {

    /**
     * Data
     */
    private Integer[] data;

    /**
     * Pointer for iterator.
     */
    private int index=0;

    /**
     * Simple constructor that takes the array and converts it spiral array.
     * @param array Input array.
     */
    public SpiralIterator(Integer[][] array){

        data=new Integer[(array.length)*(array[0].length)];
        try{
            this.convertSpiral(array,0,0,0,1);
        }catch (IllegalArgumentException e){
            System.out.println("Please give a valid input array!!");
        }


        index=-1;
    }

    /**
     * Converts current array to spiral array recursively.
     * @param array Input array.
     * @param x x coordinate.
     * @param y y coordinate.
     * @param direction 0(right),1(down),2(left),3(up)
     * @param layer It increases while method goes deeper to the array.
     * @throws IllegalArgumentException It throws if input array is inappropriate.
     */
    private void convertSpiral(Integer[][] array,int x,int y,int direction,int layer)
            throws IllegalArgumentException{
        if(array.length==1 || array == null || array[0].length==1 )
            throw new IllegalArgumentException();
        /*Right way.*/
        if(direction == 0){
            if(y== 0 || y % (array[0].length-layer) != 0 ){
                data[index++]=array[x][y];
                convertSpiral(array,x,y+1,direction,layer);
            }
            /*End of right way.*/
            else{
                data[index++]=array[x][y];
                /*End condition.*/
                if((array.length %2 == 1) &&
                        ( array.length-x == x+1) ){
                    return;
                }
                convertSpiral(array,x+1,y,1,layer);
            }
        }
        /*Down way.*/
        else if(direction == 1){
            if(x % (array.length-layer) != 0){
                data[index]=array[x][y];
                index++;
                convertSpiral(array,x+1,y,direction,layer);
            }
            /*End of down way.*/
            else{
                data[index]=array[x][y];
                index++;
                /*End condition.*/
                if((array[0].length %2 == 1) &&
                        ( y+1 == array[0].length-y ) ){
                    return;
                }
                convertSpiral(array,x,y-1,2,layer);
            }
        }
        else if(direction == 2){
            /*Left way.*/
            if(y != layer-1 ){
                data[index++]=array[x][y];
                convertSpiral(array,x,y-1,direction,layer);
            }
            /*End of left way.*/
            else{
                data[index++]=array[x][y];
                /*End condition.*/
                if((array.length %2 == 0) &&
                        ( x-layer == 0) ){
                    return;
                }
                convertSpiral(array,x-1,y,3,layer);
            }
        }
        /*Up way.*/
        else{
            if(x != layer){
                data[index++]=array[x][y];
                convertSpiral(array,x-1,y,direction,layer);
            }
            /*End of the way.*/
            else{
                data[index++]=array[x][y];
                /*End condition.*/
                if((array[0].length %2 == 0) &&
                        ( ( (array[0].length - 1) - layer ) == y ) ){
                    return;
                }
                convertSpiral(array,x,y+1,0,layer+1);
            }
        }
    }

    /**
     * Next method.
     * @return Next element inside the array.
     */
    public Integer next(){
        if(this.hasNext())
            index++;
        return data[index];
    }

    /**
     * Has next method.
     * @return true if element is not last element.
     */
    public boolean hasNext(){
        if(index < data.length-1)
            return true;

        return false;
    }
}

