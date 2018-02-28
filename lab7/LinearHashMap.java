package lab7;
 
import java.util.*;
 
public class LinearHashMap<K, V> implements Map<K, V> {
 
    private class HashMapEntry implements Entry<K, V> {
 
        private K key;
        private V value;
 
        public HashMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
 
        @Override
        public K getKey() {
            return key;
        }
 
        @Override
        public V getValue() {
            return value;
        }
 
    }
 
    private HashMapEntry[] items;
    private int numberOfItems;
 
    @SuppressWarnings("unchecked") 
    public LinearHashMap(int capacity) {
        items = (LinearHashMap<K, V>.HashMapEntry[]) new LinearHashMap.HashMapEntry[capacity];
        this.numberOfItems = 0;
    }
 
    private int hash(K key) {
        return key.hashCode();
    }
 
    private int compress(int hash) {
        return Math.abs(hash) % items.length;
    }
 
    @Override
    public int size() {
        return numberOfItems;
    }
 
    @Override
    public boolean isEmpty() {
        if(numberOfItems == 0)
            return true;
        else
            return false;
    }
   
    public Integer checkExists(K key) {
        for(int i = 0; i < items.length; i++) {
            if(items[i] != null) {
                if(items[i].getKey() != null) {
                    if(items[i].getKey().equals(key)) {
                        return i;
                    }
                }
            }
        }
        return null;
    }
   
    // only use after checkexists
    public Integer getEmpty(K key) {
        int hash = hash(key);
        int compress = compress(hash);
 
        for(int i = compress; i < items.length; i++) {
            //found null entry therefore end of list -> aka doesnt exist
            if (items[i] != null) {
                if (items[i].getKey() == null && items[i].getValue() == null) {
                    return i;
                }
            }
            else {
                return i;
            }
        }
       
        for(int i = 0; i < items.length; i++) {
            //found null entry therefore end of list -> aka doesnt exist
            if (items[i] != null) {
                if (items[i].getKey() == null && items[i].getValue() == null) {
                    return i;
                }
            }
            else {
                return i;
            }          
        }  
       
        return null;
    }
   
    @Override
    public V get(K key) {
 
        Integer position = checkExists(key);
       
        if(position == null) {
            return null;
        }
        else {
            return items[position].getValue();
        }
    }
 
    @Override
    public V put(K key, V value) {
       
        Integer position = checkExists(key);
 
        if(position == null) {
            if(getEmpty(key) == null) {
                throw new RuntimeException("Table is full");
            }
            else {
                items[getEmpty(key)] = new HashMapEntry(key,value);
                numberOfItems++;
                return null;
            }
        }
        else {
            V toReturn = items[position].getValue();
            items[position] = new HashMapEntry(key,value);
 
            return toReturn;
        }
    }
 
    @Override
    public V remove(K key) {
        Integer position = checkExists(key);
       
        if(position == null) {
            return null;
        }
        else {
            V toReturn = items[position].getValue();
            items[position] = new HashMapEntry(null,null);
            numberOfItems--;
            return toReturn;
        }
    }
 
    @Override
    public Iterable<K> keySet() {
        List<K> toReturn = new ArrayList<K>();
 
        for(int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getValue() != null && items[i].getKey() != null) {
                toReturn.add(items[i].getKey());
            }
        }
        return toReturn;
    }
 
    @Override
    public Iterable<V> values() {
        List<V> toReturn = new ArrayList<V>();
 
        for(int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getValue() != null && items[i].getKey() != null) {
                toReturn.add(items[i].getValue());
            }
        }
        return toReturn;
    }
 
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> toReturn = new ArrayList<Entry<K, V>>();
 
        for(int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getValue() != null && items[i].getKey() != null) {
                toReturn.add(items[i]);
            }
        }
        return toReturn;
    }
 
}