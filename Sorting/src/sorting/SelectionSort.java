package sorting;

public class SelectionSort {

	public static void selectionSort(int array[]){
		
		for(int i=0;i<array.length-1;i++){
			int index=i;
			
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[index])  
					index = j;
			}
				int smallestElement = array[index];
				array[index]=array[i];
				array[i]=smallestElement;	
		}
		
		printSortedArray(array);
		
	}
	
	private static void printSortedArray(int array[]){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	
	public static void main(String[] args) {
		int array[] = {2,5,1,8,3,9,23,45,1111,3};
		selectionSort(array);
	}
}
