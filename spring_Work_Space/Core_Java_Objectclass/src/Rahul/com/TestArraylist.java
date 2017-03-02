package Rahul.com;

import java.util.ArrayList;

public class TestArraylist {

	public static void main(String[] args) {
		
		
		ArrayList a = new ArrayList();
		a.add(1);
		a.add(3);
		
		
	//	a.remove(0);
	//a.set(0, 1);
	a.remove(0);
	System.out.println(a.size());
	System.out.println(a);
	ArrayList a1 = (ArrayList)a.clone();
	//a1.remove(0);
	//a1.set(0, 1);
	//a1.remove(0);
	a.remove(0);
    System.out.println(a1);
    
	ArrayList c = new ArrayList();
	c.add(true);
	c.add(false);
	c.set(1, true);
	System.out.println(c);
		a.retainAll(c);
		
		System.out.println(a);
	}
}
