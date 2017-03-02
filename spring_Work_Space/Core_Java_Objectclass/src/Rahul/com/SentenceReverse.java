package Rahul.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SentenceReverse {

	public static void main(String[] args) throws NumberFormatException, Throwable {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter string: ");
	        String s = br.readLine();
	        String reverse = "";
	        int length = s.length();

	        for (int i = length - 1; i >= 0; i--)
	            reverse = reverse + s.charAt(i);
	        System.out.println("Result:" + reverse);
	}

}
