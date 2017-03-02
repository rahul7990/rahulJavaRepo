package Collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Manager13 {
public static void main(String[] args) {
	
	Set hashSet = new HashSet();
	
	System.out.println(hashSet.add(90));
	System.out.println(hashSet.add("Rahul"));
	System.out.println(hashSet.add("Rawat"));
	System.out.println(hashSet.add(9190));

	
	System.out.println("----------------------Hash Set Size:="+hashSet.size());
	System.out.println("-------"+hashSet);
	
	System.out.println("------------first way of iterating the set values:-----------");
	for(Object a : hashSet)
	{
		System.out.println(a.toString());
	}
	
	System.out.println("------------Second way of iterating the set values:-----------");
	Iterator it = hashSet.iterator();
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
}
}
