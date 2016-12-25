package com.rahul.durga;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {
	public static void main(String[] args) {
	String year = "2016";
	String mounth = "08";
	String day = "06";
	
	//String date = year + "/" + mounth + "/" + day;
	String date = mounth + "/" + year + "/" + day;
	 java.util.Date utilDate = null;
	
	try{
		
	//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy/dd");
	utilDate = formatter.parse(date);
	
	System.out.println(utilDate);
	}catch(ParseException e){
		
		e.printStackTrace();
	}
}

}

