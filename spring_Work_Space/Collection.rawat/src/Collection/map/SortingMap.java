package Collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortingMap {

	public static void main(String[] args) {
		
		Map<String,Integer> hashMap = new HashMap();
		hashMap.put("Rahul", 107);
		hashMap.put("Preeti", 1);
		hashMap.put("Narendra", 807);
		hashMap.put("Akshay", 157);
		hashMap.put("Bijoy", 188);
		hashMap.put("Sumit", 111);

		List<String> keyList = new ArrayList();
		
		Set<String> keySet = hashMap.keySet();
		for(String key : keySet){
			keyList.add(key);
		}
		
		System.out.println("before sorting");
		System.out.println(keySet);
		Collections.sort(keyList);
		
		System.out.println("post sorting using list");
		System.out.println(keyList);
		
	}
}

