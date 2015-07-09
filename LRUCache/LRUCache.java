package LRUCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;




public class LRUCache {
	
	private int capacity;
	private int n;
	HashMap<Integer,Integer> val;
	HashMap<Integer,Integer> count;

	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        n=0;
        val = new HashMap<Integer,Integer>();
        count = new HashMap<Integer,Integer>();
    }
    
    public int get(int key) {
    	if(val.containsKey(key)){
    		int temp = count.get(key);
    		temp++;
    		count.put(key, temp);
    		return val.get(key);
    	}
    	else
    		return -1;
    }
    
    public void set(int key, int value) {
        if(val.containsKey(key)){
        	val.put(key,value);
        	count.put(key, 0);
        }
        else{
        	if(n<capacity){
        		val.put(key, value);
        		count.put(key, 0);
        		n++;
        	}
        	else{
        		Collection<Integer> c = count.keySet();
        		Iterator<Integer> it = c.iterator();
        		int min=-1;
        		int min_key=0;
        		while(it.hasNext()){
        			int temp_key = it.next();
        			int temp = count.get(temp_key);
        			if(min==-1){
        				min=temp;
        				min_key=temp_key;
        			}
        			else{
        				if(temp<min){
        					min=temp;
        					min_key=temp_key;
        				}
        			}
        		}
        		val.remove(min_key);
        		val.put(key, value);
        		count.put(key,0);
        	}
        }
    }
    
    public static void main(String[] args){
    	LRUCache lru = new LRUCache(2);
    	lru.set(2, 1);
    	
    	lru.set(1, 1);
    	System.out.println(lru.get(2));
    	lru.set(4, 1);
    	System.out.println(lru.get(1));
    	System.out.println(lru.get(2));
    }

}
