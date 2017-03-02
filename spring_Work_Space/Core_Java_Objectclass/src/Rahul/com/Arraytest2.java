package Rahul.com;

class User
{
 int i;
 User(int i)
 {
	 this.i = i;
	 
 }
 public void method1()
	{
	 
		System.out.println("::-methode::-");
		
	}
 
 public String toString()
 {
	 return "i="+i;
 }

}

public class Arraytest2 {

	
	public static void main(String[] args) {
		User []arr = new User[2];
	
		
		//arr[1].method1();  null pointer exception because we have not intiaized object value for arr.
		
		//arr[0] = new User(9);
		//	arr[1] = new User(10);
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		
		System.out.println("done");
	}
}
  