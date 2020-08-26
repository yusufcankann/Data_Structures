/**
 * Simple arraylist method for storing the data.
 *
 * @author Yusuf Can Kan
 */

import java.util.Arrays;

public class ArrayList<E> {

    /**
     * Current capacity.*/
    int capacity=0;

    /**
     * Current size.
     */
    int size=0;

    /**
     * Stored data.
     */
    E[] data;

    /**
     * Simple constructor that sets capacity to 30.
     */
    public ArrayList(){
        capacity = 30;
        data = (E[]) new Object[capacity];
    }

    /**
     * Add method for adding element to the arraylist.
     * @param data_ Elemement which is going to be add.
     * @return True if the element is added succesfully.
     */
    public boolean add(E data_){
        if (size == capacity)
            reallocate();

        data[size]=data_;
        size++;
        return true;
    }

    /**
     * Add method for adding element to the specified index.
     * @param index Index.
     * @param data_ Data which wanted to be insert.
     * @throws ArrayIndexOutOfBoundsException Throws if index is invalid.
     */
    public void add(int index,E data_)
        throws ArrayIndexOutOfBoundsException{

        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();
        if(size == capacity)
            reallocate();

        for(int i=size;i>index;i--){
            data[i] = data[i-1];
        }
        data[index]=data_;
        size++;
    }

    /**
     * Simple get method.
     * @param index
     * @return Element which given index.
     * @throws ArrayIndexOutOfBoundsException throws if index is invalid.
     */
    public E get(int index)
        throws ArrayIndexOutOfBoundsException{
        if(index<0 || index>= size)
            throw new ArrayIndexOutOfBoundsException();

        return data[index];
    }

    /**
     * Simple set method.
     * @param index Index
     * @param value_ New value.
     * @return Old value.
     * @throws ArrayIndexOutOfBoundsException Throws if index is invalid.
     */
    public E set(int index,E value_)
        throws ArrayIndexOutOfBoundsException{
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }

        E value = data[index];
        data[index]=value_;
        return value;
    }

    /**
     * Simple remove method that deletes the element which given index.
     * @param index Index.
     * @return Removed element.
     * @throws ArrayIndexOutOfBoundsException Throws if index is invalid.
     */
    public E remove(int index)
            throws ArrayIndexOutOfBoundsException{

        if(index<0 || index>= size)
            throw new ArrayIndexOutOfBoundsException();

        E temp = data[index];

        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        return temp;
    }

    /**
     * Increases capacity two times.
     */
    private void reallocate(){
        capacity *=2;
        data = Arrays.copyOf(data,capacity);
    }

    /**
     * Returns the arraylist is empty or not.
     * @return True if arraylist is empty.
     */
    public boolean isEmpty(){
        return (size==0);
    }

    /**
     * Returns current size.
     * @return Current size.
     */
    public int size(){
        return size;
    }



}
