package com.java2voice.rahul;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


//Write a program to remove duplicate entries from an array?
public class TreesetRemoveDuplicate {

	 public static void main(String a[]){
	        String[] strArr = {"one","two","three","four","four","five"};
	       // int [] array ={1,2,3,4,1,2,1};
	        //convert string array to list
	        List<String> tmpList = Arrays.asList(strArr);
	      //  List list = Arrays.asList(array);
	        //create a treeset with the list, which eliminates duplicates
	        TreeSet<String> unique = new TreeSet<String>(tmpList);
	      //  TreeSet treeSet = new TreeSet(list);
	        System.out.println(unique);
	       // System.out.println(treeSet);
	    }
}
