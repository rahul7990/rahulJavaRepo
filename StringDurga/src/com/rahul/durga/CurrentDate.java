package com.rahul.durga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentDate {
public static void main(String[] args) throws ParseException {
	
	System.out.println("-----------First way------------");
	SimpleDateFormat formate = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
	java.util.Date date = new Date();
	System.out.println("Current Date and time");
	System.out.println(formate.format(date));
	
	
	/*System.out.println("-----------second way-----------");
    Calendar cal = Calendar.getInstance();
     Date date1 = cal.getTime();
     System.out.println(date1);
     
     System.out.println("Year= "+cal.get(cal.YEAR));
     System.out.println("Month= "+cal.get(cal.MONTH));
     System.out.println("Day= "+cal.get(cal.DAY_OF_MONTH));*/
	
	
}
}
