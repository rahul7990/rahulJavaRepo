package code.java.string;

import java.util.Scanner;

public class Min_Distance_bt_tw_no {
	public static void main(String[] args) {
		
	    int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
	    int n = arr.length;
	    int x = 3;
	    int y = 6;

	    System.out.println("Minimum distance between "+x+" and "+y+" is :"+minDist(arr, n, x, y));
	   
	}

public static int minDist(int arr[], int n, int x, int y)
	{
	   int i, j;
	   int min_dist = Integer.MAX_VALUE;
	   for (i = 0; i < n; i++)
	   {
	     for (j = i+1; j < n; j++)
	     {
	         if( (x == arr[i] && y == arr[j] || y == arr[i] && x == arr[j]) && min_dist > Math.abs(i-j))
	         {
	              min_dist = Math.abs(i-j);
	         }
	     }
	   }
	   return min_dist;
	}	

}
