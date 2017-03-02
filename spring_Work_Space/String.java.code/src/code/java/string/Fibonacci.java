package code.java.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci{
	 public static void main(String args[]) throws IOException
	 {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 Fibonacci call = new Fibonacci();
	 System.out.print("Enter no. of terms : ");
	 int n = Integer.parseInt(br.readLine());
	 call.generate(n);
	 }
	 int fibo(int n)
	 {
	 if(n==1)
	  return 1;
	 else if(n==2)
	  return 1;
	 else
	  return fibo(n-2)+fibo(n-1);
	 }
	 void generate(int n)
	 {
	 for(int i=1;i<=n;i++)
	  System.out.println(fibo(i));
	 }
	}