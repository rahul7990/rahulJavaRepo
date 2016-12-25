package com.interview.code;


/*Full Program/SourceCode/ example to find Missing numbers between 
1 to 100 in sorted array in java */
public class FindMissingNumbersFromArray {

	public static void main(String[] args) {
		int [] array = {1,2,3,4,6,7,8,12};
		
		displayMissingNumbers(array);
	}

	private static void displayMissingNumbers(int[] array) {
		
		  
        int j=0;
        for(int i=1;i<=100;i++){
               if(j<array.length && i==array[j])
                     j++;
               else
                     System.out.print(i+" ");
			
		}
		
	}
}
