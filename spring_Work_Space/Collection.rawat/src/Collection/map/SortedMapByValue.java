package Collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class SortedMapByValue {
public static void main(String[] args) {
	
	Map<String,Integer> hashMap = new HashMap();
	hashMap.put("Rahul", 107);
	hashMap.put("Preeti", 1);
	hashMap.put("Narendra", 807);
	hashMap.put("Akshay", 157);
	hashMap.put("Bijoy", 188);
	hashMap.put("Sumit", 111);
	
	Set<Entry<String, Integer>> entrySet = hashMap.entrySet();
	List<Entry<String,Integer>> list = new ArrayList(entrySet);
	
	Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			
			return o1.getValue().compareTo(o2.getValue());
		}
	});
	
	System.out.println(list);
}
}
