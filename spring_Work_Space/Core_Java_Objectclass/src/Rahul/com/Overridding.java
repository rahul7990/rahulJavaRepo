package Rahul.com;

class Parent
{
	public static void m1()
	{
		System.out.println("Parent - metthod!!");
		
	}
	
	private void m2()
	{
		System.out.println("private method of parent!!!");
	}
	
	public final void m3()
	{
		System.out.println("final method of parent!!");

	}
}



public class Overridding extends Parent {

	
	public static void m1()
	{
		System.out.println("Child method!!");
	}
	
	private void m2()
	{
		System.out.println("child method of parent!!!");
	}
	
//	public final void m3()
//	{
//		System.out.println("final method of child");
//	}
	
	public static void main(String[] args) {
		
		Overridding o = new Overridding();
		o.m1();
		
        Parent p = new Parent();
        p.m1();
        p = new Overridding();
        p.m1();
	}

}
