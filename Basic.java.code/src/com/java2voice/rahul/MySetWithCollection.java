package com.java2voice.rahul;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

// How to create a TreeSet with a List?
public class MySetWithCollection {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Rahul");
		list.add("Sumit");
		list.add("Anamika");
		list.add("Preeti");
		
		TreeSet<String> treeSet = new TreeSet<String>(list);
		System.out.println(treeSet);
		
		Iterator<String> iterator = treeSet.iterator();
		
		while(iterator.hasNext()){
			System.out.println("------");
			System.out.println(iterator.next());
		}
		
	}
}
