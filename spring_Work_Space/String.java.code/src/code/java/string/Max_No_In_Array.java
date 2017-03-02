package code.java.string;

import java.util.Scanner;

public class Max_No_In_Array {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		    int array[] = new int[10];

		    System.out.println("Enter the numbers now.");

		           for (int i = 0 ; i < array.length; i++ ) {
		           int next = input.nextInt();
		          array[i] = next;
		           }
		         
		    System.out.println("These are the numbers you have entered.");
		    printArray(array);
		    
		    System.out.println();
		    
		    System.out.println("The Max no is:-"+getMaxValue(array));
	           // get smallest number
	        System.out.println("The Min no is:-"+getMinValue(array));

		}


		// getting the maximum value
		public static int getMaxValue(int[] array){  
		      int maxValue = array[0];  
		      for(int i=1;i < array.length;i++){  
		      if(array[i] > maxValue){  
		      maxValue = array[i];  

		         }  
		     }  
		             return maxValue;  
		}  

		// getting the miniumum value
		public static int getMinValue(int[] array){  
		     int minValue = array[0];  
		     for(int i=1;i<array.length;i++){  
		     if(array[i] < minValue){  
		     minValue = array[i];  
		        }  
		     }  
		    return minValue;  
		}  

		//this method prints the elements in an array......
		//if this case is true, then that's enough to prove to you that the user input has  //been stored in an array!!!!!!!
		public static void printArray(int arr[]){

		    int n = arr.length;

		    for (int i = 0; i < n; i++) {
		        System.out.print(arr[i] + " ");
		    }


}

}
