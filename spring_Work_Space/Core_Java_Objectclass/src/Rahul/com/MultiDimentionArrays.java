package Rahul.com;



public class MultiDimentionArrays {
	
	public static void main(String[] args) {
		int []a = new int[]{1,2,3};
		int []b = new int[]{4,5,6};
		int []c = new int[]{7,8,9};
		
		int [][]twoD = {a,b,c};
		
		for (int i = 0; i < twoD.length; i++) {
			for (int j = 0; j < twoD[i].length; j++) {
				
				System.out.print(twoD[i][j]+"\t");
				
			
			}
			System.out.println("\n");
		}
		
		System.out.println("Now In reverse form!!!");
		// reverse of marix
		for (int i = (twoD.length)-1; i >= 0; i--) {
			for (int j = (twoD[i].length)-1; j >= 0; j--) {
				
				System.out.print(twoD[i][j]+"\t");
				
			
			}
			System.out.println("\n");
		}
		
		
		//Now in diagonal shape
		System.out.println("Now In Diagonal shape!!!");
		
		for (int i = 0; i < twoD.length; i++) {
			for (int j = 0; j < twoD.length; j++) {
				
				if (i==j)
					System.out.print(twoD[i][j]+"\t");
				else
				{   twoD[i][j]=0;
					System.out.print(twoD[i][j]+"\t");
				}
			}
			
			System.out.println("\n");
		}
		
	}	
}
