package com.algo.core;

/*Optimal Solution for maximum subarray Problem. complexcity O(n)
 * can also perform same thing with brute force algorithum but complexcity in that case will be O(n^2)
 * */

public class KadaneAlgorithum {

	public static void main(String[] args) {
		
		int A[] = {-2,3,2,-1};
		System.out.println(Kadane(A));
	}
	
	
	private static int Kadane(int A[]){
		int max_global;
		int max_current;
		max_current = max_global = A[0];
		
		for(int i=0;i<A.length;i++){
			max_current = Math.max(A[i], A[i]+max_current);
			if(max_current > max_global)
				max_global = max_current;
		}
		return max_global;
	}
}
