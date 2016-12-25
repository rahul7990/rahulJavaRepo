package com.wrapper.classes;

public class M1 {
public static void main(String[] args) {
	
	int i = 10;
	Integer integerObject = new Integer(i);
	System.out.println("Integer Object :::-"+integerObject);
	
	int j = integerObject.intValue();
	
	System.out.println("Post converting into Primitive value j:::-"+j);
	
	String string = "10";
	
	System.out.println("Post Converting String into primitive int :::-"+new Integer(string).intValue());
	
	String string1 = "2.99";
	System.out.println("String value :::-"+string1);
	System.out.println("Post Converting into primitive double:::-"+new Double(string1).doubleValue());
	System.out.println("Post converting into primitive int :::-"+new Double(string1).intValue());

	String s1 = "true";
	String s2 = "false";
	String s3 = "abc";
	
	System.out.println("String value (true) ---to--boolean primitive:::- "+new Boolean(s1).booleanValue());
	System.out.println("String value (false) ---to--boolean primitive:::- "+new Boolean(s2).booleanValue());
	System.out.println("String value (abc) ---to--boolean primitive:::- "+new Boolean(s3).booleanValue());

   int k = 9;
   Integer integer = Integer.valueOf(k);
   System.out.println("Boxing operation with valueOf()::-"+integer);

    int h = 999999;
    double g = 99.9999;
    boolean boo = true;
    
    System.out.println("Coverting h(99999), g(99.9999) and boo(true) to String :::-");
    System.out.println("Converting double to String:::-"+Double.toString(g));
    System.out.println("Converting int to String:::-"+Integer.toString(h));
    System.out.println("Converting boolean to String:::-"+Boolean.toString(boo));
    
    String string4 = "444";
    String string5 = "127";
    
    System.out.println("Converting String to integer:::-"+Integer.parseInt(string4));
    System.out.println("Converting String to double:::-"+Double.parseDouble(string4));
    System.out.println("Converting String to boolean:::-"+Boolean.parseBoolean(string4));
    System.out.println("Converting String to long:::-"+Long.parseLong(string4));
    System.out.println("Converting String to byte:::-"+Byte.parseByte(string5));
    System.out.println("Converting String to Short:::-"+Short.parseShort(string4));
    
    
    

}
}
