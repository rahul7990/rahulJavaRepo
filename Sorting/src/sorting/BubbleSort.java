package sorting;

public class BubbleSort {

public static void bubbleSort(int array[]){
	
	for(int i=0;i<=array.length;i++){
		for(int j=i+1;j<array.length;j++)//if j you are taking 0 then [j=0;j<array.length-1;j++]
		{
			if(array[i]>array[j]){
				swap(i, j, array);
			}
		}
	}
	
	printSortedArray(array);
}

private static void swap(int i,int j,int array[]){
	
	int temp;
	
	temp = array[i];
	array[i]=array[j];
	array[j]=temp;
	
}

private static void printSortedArray(int array[]){
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i]);
	}
}

public static void main(String[] args) {
	int array[] = {2,5,1,8,3,9,23,45,1111,3};
	bubbleSort(array);
}
}
