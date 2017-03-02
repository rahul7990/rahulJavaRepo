package code.java.string;

import java.util.Scanner;

public class Max_two_no_Array {
	public static void main(String[] args) {
		int []arr = new int[10];
		int next=0;
		int Maxone = 0;
		int Maxtwo = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter array value:");
		
		for (int i = 0; i < arr.length; i++) {
			next = sc.nextInt();
			arr[i] = next;
		}

		for(int n : arr)
		{
			if(Maxone < n )
			{
				Maxtwo = Maxone;
				Maxone = n;
			}
			else if(Maxtwo < n){
				//2 3 4 5 6 7 8 9 99 12

	            Maxtwo = n;

	        }

		
				}
		
		System.out.println("First Max number is:-"+Maxone);
		System.out.println("Second Max number is:-"+Maxtwo);
	}

}
