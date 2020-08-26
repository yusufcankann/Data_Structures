import java.util.Iterator;

/**
 * Simple iterator class that has hasNext and next method.
 */
public class Word_Map_Iterator implements Iterator {

    private Word_Map.Node entry;

    /**
     * Simple constructor that takes the first entry of the map.
     * @param first_entry First entry.
     */
    public Word_Map_Iterator(Word_Map.Node first_entry){
        entry=first_entry;
    }

    /**
     * Checks if there exist a next element.
     * @return true if it has next element.
     */
    @Override
    public boolean hasNext(){
        if(entry.next != null)
            return true;

        return false;
    }

    /**
     * Iterates element one forward.
     * @return Next element.
     */
    @Override
    public Word_Map.Node next(){

        if(entry == null){
            return null;
        }

        Word_Map.Node oldEntry = entry;
        entry=entry.next;
        return oldEntry;
    }

}
