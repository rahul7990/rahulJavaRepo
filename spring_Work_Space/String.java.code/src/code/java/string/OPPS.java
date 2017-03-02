package code.java.string;

//Rare Mile COde
class A
{
	
static {
	
	System.out.println("Static block");
}

public A()
{
  System.out.println("Default of super class A");	
}


public A(int a,int b)
{
System.out.println("Paramatrized of super class A");	
}

}



public class OPPS extends A {

	public	OPPS()
	{
		System.out.println("Default of OPPS");
	}
	
	public OPPS(int a, int b)
	{
		System.out.println("paramatrized of OPPS:");
	}

	public static void main(String[] args) {
		
		A a = new OPPS(2,3);
	}

}
