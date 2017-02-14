package com.selection.algorithums;

public class MainFindSmallAndLargeestWithoutComparision {

	private static void FindSmallestAndLargestInArray(int[] array, int n){
		
		int small = array[0];
		int large = array[0];
		
		for(int i = 1;i<=n-1;i++){
			if(array[i] < small)
				small = array[i];
			else if(array[i] > large)
				large = array[i];
		}
		
		System.out.println("Smallest : " + small + " Largest : " + large);

	}
	
	public static void main(String[] args) {
		
		int array [] = {5,77,88,4,22,66,2,1,0};
		FindSmallestAndLargestInArray(array,array.length);
	}
}
