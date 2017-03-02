package code.java.string;

import java.util.StringTokenizer;

public class Sum_of_no_from_given_sentance {

	public static void main(String[] args) {
		String str1= null;
		int sum=0;
		int count=0;
		
		
		
		StringTokenizer str = new StringTokenizer("Rahul had 120 rs but currently he has 140 rs !!!");
		while(str.hasMoreTokens())
		{  
			int x=0;
			str1 = str.nextToken();
			if((str1.equals("120"))||(str1.equals("140")))
			{
			   x = Integer.parseInt(str1);
			  sum = sum+x;
			}
		}
		System.out.println("The sum of int type values are :"+sum+"\n");
		
	}

}
