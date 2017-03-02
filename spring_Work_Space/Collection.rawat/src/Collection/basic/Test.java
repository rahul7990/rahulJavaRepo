package Collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test {
public static void main(String[] args) {
	ArrayList aList = new ArrayList();

	//Add elements to ArrayList object
	aList.add("1");
	aList.add("2");
	aList.add("3");
	aList.add("4");
	aList.add("5");

	   ArrayList list = reverse(aList);
	System.out.println(list);
	
	//list = reverseNonRecursive(aList);
	//System.out.println(list);
//-------------------------------//1st way to reverse the arrayList:-------
	//Collections.reverse(aList);
	//System.out.println(aList);
}

//------------------------------//2nd way using Recursive method to reverse an element:---
public static ArrayList<Object> reverse(ArrayList<Object> list) {
    if(list.size() > 1) {                   
        Object value = list.remove(0);
        reverse(list);
        list.add(value);
    }
    return list;
}

//------------------------------//3rd way using Recursive method to reverse an element:---
public static ArrayList reverseNonRecursive(ArrayList list)
{
	for(int i=0,j=list.size()-1;i<list.size()-1;i++,j--)
	{
		list.add(i, list.remove(j));
		}
	
	return list;
}
}
