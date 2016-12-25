package com.rahul.durga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DateSorting {
	
	public static void main(String[] args) throws ParseException {
		
		
		SimpleDateFormat formate = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date1 = new Date();
		
		List<Date> datelist = new ArrayList<Date>();
		datelist.add(formate.parse("01-02-2002"));
		datelist.add(formate.parse("09-09-1990"));
		datelist.add(formate.parse("03-04-1902"));
		datelist.add(formate.parse("09-12-1990"));
		datelist.add(formate.parse("05-02-2002"));
		datelist.add(formate.parse("10-09-1990"));	
		datelist.add(new Date(2015-1900, 01, 01));
		datelist.add(new Date(2016-1900, 01, 01));
		
		System.out.println(datelist);
		
		Collections.sort(datelist, new Comparator<Date>() {

			@Override
			public int compare(Date date1, Date date2) {
				return date1.compareTo(date2);
			}
			
		});
		
		System.out.println("------------:Post Sorting Date:-------");
		System.out.println(datelist);
		
		System.out.println("------------:Iterating date with iterator:-------");
		Iterator<Date> iterator = datelist.iterator();
		while (iterator.hasNext()) {
			Date date = (Date) iterator.next();
			System.out.println(date);
			
		}
	}

}
