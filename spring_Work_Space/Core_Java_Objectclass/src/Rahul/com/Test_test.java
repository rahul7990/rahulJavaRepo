package Rahul.com;

import java.util.HashMap;
import java.util.Map;

public class Test_test {
public static void main(String[] args) {
	
	Map<String,Integer> hashMap = new HashMap<String,Integer>();
	
	hashMap.put("Rahul", 127161);
	hashMap.put("Akshay", 127163);
	hashMap.put("Amit", 127901);
	hashMap.put("Naved", 127898);
	hashMap.put("Lala",123456);
	
	System.out.println(hashMap);
	System.out.println();
	System.out.println("================================================================");

	for (Map.Entry<String,Integer>entry : hashMap.entrySet()) {
		System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	}
	System.out.println("================================================================");
	for(String Key: hashMap.keySet())
	{
		System.out.println(Key.toString() +":  Value :"+hashMap.get(Key));
	}
	
	for(Integer Value : hashMap.values())
	{
		System.out.println(Value.toString());
	}
}
}
