package Collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestMap {
public static void main(String[] args) {
	
	
	Map<String,Integer> hashMap = new HashMap();
	hashMap.put("Rahul", 107);
	hashMap.put("Preeti", 1);
	hashMap.put("Narendra", 807);
	hashMap.put("Akshay", 157);
	hashMap.put("Bijoy", 188);
	hashMap.put("Sumit", 111);
	
	// using KeySet
	System.out.println("--------- using keySet --------------------");
	Set<String> keySet = hashMap.keySet();
	
	for(String key : keySet){
		System.out.println(key);
		System.out.println(hashMap.get(key));
	}
	
	// using key through iterator
	System.out.println("---------- using iterator over keySet ----------");
	Iterator<String> keyIterator = hashMap.keySet().iterator();
	
	while(keyIterator.hasNext()){
		String key = keyIterator.next();
		Integer value = hashMap.get(key);
		System.out.println("key : "+key+" value : "+value);
		
		//System.out.println(keyIterator.next());
	}
	
	// using value
	System.out.println("---------- using value ---------------------------");
	Collection<Integer> valueCollection = hashMap.values();
	
	for(Integer value : valueCollection){
		System.out.println(value);
	}

	// using iterator over values
	/*System.out.println("-----------  using iterator over values -----------");
    Iterator<Integer> valueiterator = hashMap.values().iterator();
	
    while(valueiterator.hasNext()){
    	System.out.println(valueiterator);
    }*/
	
	// sorting hashmap
	System.out.println("sorting the hashMap using treemap:");
	TreeMap<String,Integer> treeMap = new TreeMap(hashMap);
	System.out.println(treeMap);
	// it will sort based on the key:
	
	
}
}
