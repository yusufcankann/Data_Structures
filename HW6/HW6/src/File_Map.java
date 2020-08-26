import java.util.*;

/**
 * Simple map class that hold string(File Name) for keys and index places for key values.
 */
public class File_Map implements Map
{
    /**
     * File names.
     */
    ArrayList<String> fnames;

    /**
     * Index numbers.
     */
    ArrayList<List<Integer>> occurances;

    /**
     * Simple constructor that creates key and value array list.
     */
    public File_Map(){
        fnames = new ArrayList<>();
        occurances = new ArrayList<>();
    }

    /**
     * Return size of the map.
     * @return size.
     */
    @Override
    public int size() {
        return fnames.size();
    }

    /**
     * Checks if the map is empty or not.
     * @return True if map is empty.
     */
    @Override
    public boolean isEmpty() {
        return fnames.isEmpty();
    }

    /**
     * Controls if the map has the given key or not.
     * @param key Key.
     * @return True if map contains the given key.
     */
    @Override
    public boolean containsKey(Object key) {
        return fnames.contains(key);
    }

    /**
     * Controls if the map has the given value or not.
     * @param value Key.
     * @return True if map contains the given value.
     */
    @Override
    public boolean containsValue(Object value) {
        return (occurances.contains(value));
    }

    /**
     * Simple get method that gets the value with respect to given key.
     * @param key Key
     * @return Value.
     */
    @Override
    public Object get(Object key) {

        int size = fnames.size();

        for(int i=0;i<size;i++){
            if(fnames.get(i).equals(key)){
                return occurances.get(i);
            }
        }
        return null;
    }

    /**
     * Simple put method that adds the given key and value in the map.
     * If map has the given key it changes the value.
     * @param key Key.
     * @param value Value.
     * @return Returns old value or null.
     */
    @Override
    public Object put(Object key, Object value) {

        if(fnames.contains(key)){
            int size = fnames.size();
            for(int i=0;i<size;i++){
                if(fnames.get(i).equals(key)){
                    List<Integer> oldValue = occurances.get(i);
                    occurances.set(i,(List<Integer>) value);
                    return oldValue;
                }
            }
        }

        fnames.add((String)key);
        occurances.add((List<Integer>) value);
        return null;
    }

    /**
     * Remove method that removes the given key and value inside the list.
     * @param key
     * @return
     */
    @Override
    public Object remove(Object key) {
        if(!fnames.contains(key) ){
            return null;
        }
        int size = fnames.size();
        for(int i=0;i<size;i++){
            if(fnames.get(i).equals(key)){
                List<Integer> oldValue = occurances.get(i);
                occurances.remove(oldValue);
                fnames.remove(key);
                return oldValue;
            }
        }
        return null;
    }

    /**
     * Puts all the element inside the given map.
     * @param m Map.
     */
    @Override
    public void putAll(Map m) {
        Set keys = m.keySet();

        for(Object i:keys){
            put(i,m.get(i));
        }
    }

    /**
     * Deletes all the keys and values inside the map.
     */
    @Override
    public void clear() {
        fnames.clear();
        occurances.clear();
    }

    /**
     * Returns set of keys for this map.
     * @return Set of keys.
     */
    @Override
    public Set keySet() {
        Set set = new HashSet();
        for(Object i:fnames){
            set.add(i);
        }
        return set;
    }

    /**
     * Returns values list for this map.
     * @return Value list.
     */
    @Override
    public Collection values() {
        return occurances;
    }

    /**
     * For every key and value it creates an entry object and
     * holds every object inside the set and returns it.
     * @return set of entry.
     */
    @Override
    public Set<Entry> entrySet() {

        Set set = new HashSet();

        for(int i=0;i<fnames.size();i++){
            Entry<String,List<Integer>> entry=new MyEntry(fnames.get(i),occurances.get(i));
            set.add(entry);
        }

        return set;
    }


}
