package code.java.string;

public class MissingNumber {
	public static void main(String[] arg){
		
	    int a[] = {1,3};
	    int miss = getMissingNo(a);
	    System.out.println(miss);
	   
}

public static int getMissingNo(int[] a) {
	int total;
    total  = ((a.length)+1)*((a.length)+2)/2;
   // System.out.println(total);
    for ( int i = 0; i< a.length; i++)
       total -= a[i];
    return total;
}

}
