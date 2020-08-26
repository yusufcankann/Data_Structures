import java.util.EmptyStackException;

/**
 * A simple class that implements stack.
 * @author Yusuf Can
 */
public class MyStack<T> extends Math {

    /**
     * Inner array which holds to data.
     */
    private T data[];

    /**
     * Holds the top of the stack index.
     */
    private int top;

    /**
     * Holds the capacity.
     */
    private int capacity;

    /**
     * Simple constructor that allocates 100 space for
     * inner array and sets top to -1,capacity to 100.
     */
    public MyStack(){
        data=(T[])new Object[100];
        top = -1;
        capacity = 100;
    }

    /**
     * Pushes the data to the top of the stack.
     * @param data Data.
     * @return Pushed data.
     */
    public T push(T data){

        if(top==capacity-1){
            T[] temp1 = (T[])new Object[capacity*2];
            int counter=0;
            while(counter<top) {
                temp1[counter] = this.data[counter];
            }
            this.data=temp1;
        }

        top++;
        this.data[top] = data;

        return data;
    }

    /**
     * Returns the data at the top of the stack and removes it.
     * @return Top of the stack.
     * @throws EmptyStackException It throws if stack is empty.
     */
    public T pop(){

        if(this.empty()){
            throw new EmptyStackException();
        }

        return data[top--];
    }

    /**
     * Returns at the top of the stack but does not remove.
     * @return Top of the stack.
     * @throws EmptyStackException It throws if stack is empty.
     */
    public T peek(){

        if(this.empty()){
            throw new EmptyStackException();
        }

        return data[top];

    }

    /**
     * Checks if the stack is empty or not.
     * @return True if stack is empty.
     */
    public boolean empty(){
        return (top == -1);
    }



}
