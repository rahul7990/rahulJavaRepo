package Rahul.com;

import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		
		int number1, number2; 

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integers");
        number1 = in.nextInt();
        number2 = in.nextInt();
        System.out.println(findNumberOfBits(number1,number2));
        System.out.println("bit cont in 16");
        System.out.println(bitcountfun(16));
}

	public static int findNumberOfBits(int x, int y)
{
	int bitCount = 0;

	int z = x ^ y;  //XOR x and y

	while (z != 0)
	{
	  //increment count if last binary digit is a 1:
	  bitCount += z & 1; 
	  z = z >> 1;  //shift Z by 1 bit to the right
	}

	return bitCount;
	}
	
	public static int bitcountfun(int n)
	{  int bitCount =0;
		
		while (n != 0)
		{
		  //increment count if last binary digit is a 1:
		  bitCount += n & 1; 
		  n = n >> 1;  //shift Z by 1 bit to the right
		}
		
		return bitCount;
	}
	
	
}// class 