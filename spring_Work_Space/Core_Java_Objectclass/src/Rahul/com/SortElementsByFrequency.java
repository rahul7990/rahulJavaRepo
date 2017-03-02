package Rahul.com;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortElementsByFrequency {
	static LinkedHashMap hm = new LinkedHashMap();
	public static void main(String[] args)
	{
	//int[] a = {2,3,4,2,8,1,1,2};
	int[] a = {2,2,2,1,1,1,3,4,8};
	frequencyCount(a);

	//Adding entrySet to LinkedList

	List<Map.Entry> list = new LinkedList<Map.Entry>(hm.entrySet());

	Collections.sort(list,new Comparator<Map.Entry>()
	{

	@Override
	public int compare(Entry arg0,Entry arg1) {

	return arg1.getValue()-arg0.getValue();
	}

	});

	for(Map.Entry i:list)
	{
	for(int j=0;j< (i.getValue());j++)
	{
	System.out.print(i.getKey()+" ");
	}
	System.out.println();
	}

	}

	public static void frequencyCount(int[] a)
	{
	for(int i=0;i<a.length;i++)
	{
	if(hm.containsKey(a[i]))
	//hm.put(a[i],hm.get(a[i])+1);
		hm.put(a[i],(hm.get(a[i]))+1);
	else
	hm.put(a[i], 1);

	}

	}
}
