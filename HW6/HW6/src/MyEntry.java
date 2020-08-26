import java.util.Map;

/**
 * Simple entry class for key and value.
 * @param <K> Key.
 * @param <V> Value.
 */
public class MyEntry<K,V> implements Map.Entry<K,V>{
    /**
     * Key
     */
    private K key;

    /**
     * Value.
     */
    private V value;

    /**
     * Simple constructor that sets the key and value.
     * @param key Key.
     * @param value Value.
     */
    public MyEntry(K key,V value){
        this.key=key;
        this.value=value;
    }

    /**
     * Getter method for key.
     * @return Key.
     */
    public K getKey(){
        return key;
    }

    /**
     * Getter method for the value.
     * @return Value.
     */
    public V getValue(){
        return value;
    }

    /**
     * Setter method for the value.
     * @param value Value.
     * @return Old value.
     */
    public V setValue(V value){
        V oldValue = this.value;
        this.value=value;
        return oldValue;
    }
}