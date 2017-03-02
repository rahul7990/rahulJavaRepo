 package code.java.string;

import java.util.Scanner;

public class Palindrome
{
	public static void main(String[] args) {
	String str;
    System.out.println("Enter a string to verify paindrome or not:!!");
	Scanner sc = new Scanner(System.in);
	
	str = sc.next();
	
	if(isPalindrome(str))
	{
		System.out.println("String:-"+str+" is palindrome");
	}

	else{
		System.out.println("String:-"+str+" is not palindrome");
	}
}

public static boolean isPalindrome(String str)
{
	return isPalindrome(str,0,str.length()-1);
}

   public static boolean isPalindrome(String str,int low, int high)
    {  if(high <= low)
        return true;
        else if (str.charAt(low)!= str.charAt(high))
        return false;
        else
        return isPalindrome(str,low+1,high-1);
     }

}   