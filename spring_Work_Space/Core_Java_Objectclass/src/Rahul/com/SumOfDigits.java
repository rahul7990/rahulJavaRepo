package Rahul.com;

import java.util.Scanner;

public class SumOfDigits
{ 
    static int ultimateSum(int number) {
  int sum = 0;
  int input = number;
   while (input != 0) {
	int lastdigit = input % 10; 
	sum += lastdigit; 
	input /= 10; 
	} 
   
   if ((sum % 10)!=0)
      ultimateSum(sum);
      
      return sum;
    }
	
  static int sumDigits(int n) {
    	  int sum = 0;
    	  if(n == 0){
    	  return 0;
    	  }
    	  sum += n % 10; //add the sum
    	  n /= 10; //keep cutting
    	  return sum + sumDigits(n); //append sum to recursive call
    	}
	
	public static void main(String args[]) 
	
{
	

Scanner sc = new Scanner(System.in);
System.out.println("Please enter a number to calculate sum of digits");
int number = sc.nextInt(); 
// Remember number/10 reduces one digit from number
// and number%10 gives you last digit

int Sum = ultimateSum(number);
//int Sum= sumDigits(number);

System.out.printf("Sum of digits of number %d is %d", number, Sum);
// closing Scanner to prevent resource leak 
sc.close(); 
} 

}


