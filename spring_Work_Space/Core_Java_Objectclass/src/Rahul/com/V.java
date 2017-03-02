package Rahul.com;
//shallow copy example
class Test
{
	
  int i;

}

public class V implements Cloneable{
	int j;
	Test_test t;
	
	public static void main(String[] args) throws Throwable {
		
		Test_test t1 = new Test_test();
		t1.i=100;
		
		V v1=new V();
		v1.j=22;
		v1.t=t1;
		
		V v2 = (V)v1.clone();
		
		System.out.println(v2.j);
		System.out.println(v2.t.i);
		v1.j=33;
		v1.t.i=1000;
		
		System.out.println(v2.j);
		System.out.println(v2.t.i);
		
	}

}
