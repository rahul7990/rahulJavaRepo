package Rahul.com;

class A
{
  int i;
  
  public void method()
  {
	  System.out.println("method of A");
	  
  }
}


class B extends A
{
	
	public void method()
	  {
		  System.out.println("Overrided method of B");
		  
	  }
  

}

public class Array3 {

	public static void main(String[] args) {
		
		A []arr = new A[3];
		
		arr[0] = new B();
		arr[1] = new B();
		arr[2] = new B();
		
		arr[0].method();
		arr[1].method();
		arr[2].method();
		
		System.out.println(arr[0]);
		
		
	}
	
}
