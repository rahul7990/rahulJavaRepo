package com.rahul.durga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparision {

	public static void main(String[] args) {
		
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date1 =  formate.parse("2001-02-01");
			java.util.Date date2 =  formate.parse("1990-02-01");
			java.util.Date date3 =  formate.parse("2001-03-01");
			java.util.Date date4 =  formate.parse("1990-02-01");
			
			System.out.println("Compare date1 and date3"+date1.compareTo(date3));
			if((-1)==date1.compareTo(date3)){
				System.out.println("date1 is greatter then date2:");
				System.out.println("------------------------------");
			}
			
			System.out.println("Compare date2 and date3"+date2.compareTo(date3));
			System.out.println("--------------------------------");
			System.out.println("Is date1 before then date3:");
			System.out.println(date1.before(date3));
			System.out.println("---------------------------------");
			System.out.println("Is date2 after from date1:");
			System.out.println(date2.after(date1));
			
			System.out.println("---------------------------------");
			System.out.println("Date comparsion with equals:");
			System.out.println(date2.equals(date4));
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
