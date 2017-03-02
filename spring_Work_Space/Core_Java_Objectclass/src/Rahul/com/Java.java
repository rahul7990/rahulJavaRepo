package Rahul.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Java {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(127161, "Rahul");
		map.put(127162, "Abhishek");
		map.put(127163, "Akshay");
		map.put(127164, "Sonakshi");
		map.put(127169, "Nirav");
		map.put(127166, "Pratik");
		
		Set<Entry<Integer,String>> entry = map.entrySet();
		List<Map.Entry<Integer,String>> list = new ArrayList<Entry<Integer,String>>(entry);
		Collections.sort(list, new Comparator<Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				String s1 = o1.getValue();
				String S2 = o2.getValue();
				return s1.compareTo(S2);
			}
			
		});
		
		for(Map.Entry<Integer, String> e : list)
		{
			System.out.println("Key "+e.getKey()+":"+"Value "+e.getValue());
		}
		
	}
}
