package com.recursion;

/*A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself. 
A natural number greater than 1 that is not a prime number is called a composite number.
*/
public class PrimeNumbers {

	public static void main(String[] args) {
		
		int number = 0;
		
		while(number!=100){
			int count = 0;
		  for(int i = 2; i<=number/2;i++){
			
			  if(number%i==0)
				  count++;
				 
			  } 
		  if(count == 0 && (number!=0 && number!=1))
			System.out.println(number+" is prime");
		  number++;
	}
}
}
