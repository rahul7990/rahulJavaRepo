package com.string.java;


public class ReverseStringRecursivly {

	  private String reverse(String str) 
	    {     
	        if ((str==null)||(str.length() <= 1) )
	            return str;
	      
	        return reverse(str.substring(1)) + str.charAt(0);
	    }
	    public static void main(String[] args) 
	    {
	    	ReverseStringRecursivly obj= new ReverseStringRecursivly();
	        String str = "Rahul";
	        System.out.println("Reverse of \'"+str+"\' is \'"+obj.reverse(str)+"\'");    
	    }    
}
