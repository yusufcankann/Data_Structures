import java.util.*;

/**
 * Word Map class that hols the word string for the key and another File Map class for the value.
 */
public class Word_Map implements Map, Iterable
{

    final static int INITCAP=10;  //initial capacity
    int CURRCAP = INITCAP;   //current capacity
    final static float LOADFACT = 0.75f;
    private Node table[];

    /*First entry index for the linked list structure.(Head)*/
    private int first_entry_index=-1;
    private int remove_count=0;

    /*Current element count.*/
    private int size=0;

    /**
     * Simple constructor that sets table capacity to 10;
     */
    public Word_Map() {
        this.table = new Node[INITCAP];
    }

    /**
     * Simple iterator method that returns the iterator.
     * @return Iterator for Word_Map.
     */
    @Override
    public Iterator iterator() {
        Word_Map_Iterator wm = new Word_Map_Iterator(table[first_entry_index]);
        return wm;
    }

    /**
     * Inner node class that holds key,next,value.
     */
    static class Node {
        // complete this class according to the given structure in homework definition
        String key=null;
        Node next=null;
        File_Map value=null;

    }

    /**
     * Size method.
     * @return Size of word map.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if word map is empry.
     * @return true if it is empty.
     */
    @Override
    public boolean isEmpty() {
        return (first_entry_index == -1);
    }

    /**
     * Controls if it has given key or not.
     * @param key Key.
     * @return True if word map has the given key.
     */
    @Override
    public boolean containsKey(Object key) {

        /*If no element inserted to the hashmap.*/
        if(this.isEmpty()){
            return false;
        }

        /*If it finds the key with the index calculation it returns true.*/
        if(table[find(key)] != null && key.equals(table[find(key)].key) )
            return true;


        Node start = table[first_entry_index];

        /*If first element is the key.*/
        if(start.key.equals(key)){
            return true;
        }

        while(start.next!=null){
            if(start.next.key.equals(key)){
                return true;
            }
            start = start.next;
        }
        return false;

    }

    /**
     * Controls if it has given value or not.
     * @param value Value.
     * @return True if the word map has given value.
     */
    @Override
    public boolean containsValue(Object value) {

        /*If no element inserted to the hashmap.*/
        if(this.isEmpty()){
            return false;
        }

        Node start = table[first_entry_index];

        /*If first element is the key.*/
        if(start.value.equals(value)){
            return true;
        }

        while(start.next!=null){
            if(start.next.value.equals(value)){
                return true;
            }
            start = start.next;
        }
        return false;

    }

    /**
     * Gets the given keys value.
     * @param key Key
     * @return Null if it doesn't have given key.
     */
    @Override
    public Object get(Object key) {

        /*If element inside the table, find method finds that element and returns its index.*/
        int index = find(key);

        if(table[index] != null){
            return table[index].value;
        }
        else return null;
    }

    /**
     * Puts the given key and value inside the word map.
     * @param key Key.
     * @param value Value.
     * @return null if it has given key.
     */
    @Override
    public Object put(Object key, Object value) {
        int index = find(key);

        /*If there is no other element which has this key.*/
        if(table[index] == null){

            table[index] = new Node();
            table[index].key = (String)key;
            table[index].value = (File_Map)value;


            if(first_entry_index != -1){
                Node head = table[first_entry_index];
                while(head != null && head.next!=null){
                    head = head.next;
                }

                if(head==null){
                    head = table[index];
                }
                else{
                    head.next=table[index];
                }
            }else{
                first_entry_index=index;
            }

            size++;

            double load_fact = (size+remove_count)/table.length;

            if(load_fact > LOADFACT){
                rehash();
            }

            return null;
        }

        /*If there is element in that key, replace its value.*/
        File_Map old_value = table[index].value;
        table[index].value = (File_Map) value;

        return old_value;
    }

    /**
     * Finds the proper index for given key. If the first founded index is not proper
     * it looks for another empty cell inside the table.
     * @param key Key.
     * @return Proper index.
     */
    public int find(Object key){
        int index = key.hashCode() % table.length;

        if(index < 0 ) index += table.length;

        while(table[index] != null && !(key.equals(table[index].key)) ){

            index++;
            if(index>=table.length){
                index=0;
            }
        }
        return index;
    }

    @Override
    /*You do not need to implement remove function
     * */
    public Object remove(Object key) {
        return null;
    }

    /**
     * Puts all the keys and values inside the given map.
     * @param m Map.
     */
    @Override
    public void putAll(Map m) {
        Set set = m.keySet();

        for(Object i:set){
            put(i,m.get(i));
        }
    }

    /**
     * Clears all the keys and values inside the map.
     */
    @Override
    public void clear() {


        Node delete = table[first_entry_index];
        Node next_node = delete.next;
        table[find(delete.key)]=null;

        while(next_node != null){
            delete=next_node;
            next_node = delete.next;
            table[find(delete.key)]=null;
        }

        size=0;
        first_entry_index=-1;
    }

    /**
     * Returns set of keys for this map.
     * @return Set of keys.
     */
    @Override
    public Set keySet() {

        Set set = new HashSet();
        if(first_entry_index==-1) return null;

        Node head = table[first_entry_index];

        if(head != null){
            while(head.next != null){
                set.add(head.key);
                head = head.next;
            }
            set.add(head.key);
        }

        return set;
    }

    /**
     * Returns set of values for this map.
     * @return Set of values.
     */
    @Override
    public Collection values() {

        if(first_entry_index==-1) return null;

        Collection values = new ArrayList();
        Node head = table[first_entry_index];

        if(head !=null){
            while(head.next!=null){
                values.add(head);
                head = head.next;
            }
            values.add(head);
        }
        return values;
    }

    @Override
    /*You do not need to implement entrySet function
     * */
    public Set<Entry> entrySet() {
        return null;
    }

    /**
     * Rehashes all hashtable with growing table size.
     */
    private void rehash(){

        Node[] old_table = table;

        CURRCAP*=2;
        table = new Node[CURRCAP*2];

        size=0;
        first_entry_index=-1;

        for(int i=0;i<old_table.length;i++){
            if(old_table[i] != null){
                this.put(old_table[i].key,old_table[i].value);
            }
        }


    }
}
