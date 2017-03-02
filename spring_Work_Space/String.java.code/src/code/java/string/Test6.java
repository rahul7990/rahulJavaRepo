package code.java.string;

class Equal
{
  int a;
  
  Equal(int a)
  {
	  
	  this.a=a;
  }
  
  

}

public class Test6 {
	
	
	public static void main(String[] args) {
		
		Equal a1 = new Equal(1);
		Equal a2 = new Equal(1);
		
		System.out.println(a1==a2);
		System.out.println(a1.equals(a2));
		
	}
	

}
