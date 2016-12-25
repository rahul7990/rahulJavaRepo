package com.jvm.core;

public class CallByRefrence {
	 int a;
	CallByRefrence(int a)
	  { this.a=a;}
	void swap(CallByRefrence o)
	{
	  int temp=this.a;
	   this.a=o.a;
	   o.a=temp;
	}
	public static void main(String args[])
	{
		CallByRefrence obj1=new CallByRefrence(5);
		CallByRefrence obj2=new CallByRefrence(7);
	System.out.println("obj1 has integer value->"+obj1.a);
	System.out.println("obj2 has integer value->"+obj2.a);
	
	
	  obj1.swap(obj2);//this should swap using call by reference
	  
	  
	System.out.println("obj1 has integer value->"+obj1.a);
	System.out.println("obj2 has integer value->"+obj2.a);
	
	
	
	}
	}

