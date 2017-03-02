package Rahul.com;

import java.util.Vector;


public class TestVector {
	public static void main(String[] args) {
		
	
	Vector v = new Vector();
	v.add(10);
	v.add(23);
	v.add(34);
	v.add(true);
	v.add(10);
	v.add(23);
	v.add(34);
	v.add(true);
	v.add(10);
	v.add(23);
	v.add(34);
	v.add(true);
	
	v.addElement(1);
	System.out.println(";;;;;;;");
	System.out.println(v.add(1));
	
	//v.removeElementAt(3);
	System.out.println("removed");
	System.out.println(v.remove(3));
	v.insertElementAt(true, 0);
	v.setElementAt(false, 1);
	System.out.println(v);
	System.out.println(v.size());
	System.out.println(v.capacity());
	
	//v.ensureCapacity(100);
	//System.out.println(v.capacity());
	
	}

}
