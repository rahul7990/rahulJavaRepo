package Rahul.com;

import java.util.Arrays;

public class ArrayTest {
public static void main(String[] args) {
	
	int []a;
	a = new int[2];
	//int a = new int[];  here  a will treated as any normal int refrence not as an int array reference.
	
	
	
	for (int i = 0; i < a.length; i++) 
	{ 
	      a[i]= i+10;
	
		System.out.println(a[i]);
	}
		
		int[] arr = new int[a.length];
		
		System.out.println("first way of copying aaray a data into arr!!!");
		for (int j = 0; j < a.length; j++)
		{
		 
			arr[j] = a[j];
			
			System.out.println(arr[j]);
		}
	
		System.out.println("Second way of copying aaray a data into brr by copyOf() of arrays class!!!");
		
	int []brr = Arrays.copyOf(a, a.length);
	
	System.out.println(brr[0] );
	System.out.println(brr[1] );
	
	System.out.println("3rd way of copying aaray a data into crr by clone()!!!");
	
	int []crr = a.clone();
	System.out.println(crr[0] );
	System.out.println(crr[1] );
	
	

}
}

