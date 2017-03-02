package Rahul.com;
import java.util.Scanner;

public class ReversedBinary {

    public static void main(String[] args) {
        int number; 

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integer");
        number = in.nextInt();

        if (number < 0) {
            System.out.println("Error: Not a positive integer");
        } else { 

            System.out.print("Convert to binary is:");
          //  System.out.println( bitcount(number));
            //System.out.print(binaryform(number));
            printBinaryform(number);
          
            
        }
    }

    private static void printBinaryform(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            return;   // KICK OUT OF THE RECURSION
        }

        remainder = number %2; 
       // System.out.print(remainder);
        printBinaryform(number >> 1);
       System.out.print(remainder);
    }
    
    private static int bitcount(int n) {
        int tot = 0;
        int a = 0;
     
        int i;
        for (i = 1; i <= n; i = i<<1)
        {   a = n & i;
        if(a==1)
                ++tot;
        }
        return tot;
    }
  
}