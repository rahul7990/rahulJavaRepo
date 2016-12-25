package com.hackerrank;

import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
      //Logic to calculate sum of diagonal1
        int sumOfDiagonal1=0;
        for (int i = 0, j =0; i< n && j < n; i++, j++) {
               sumOfDiagonal1= sumOfDiagonal1 + a[i][j];
               
        }
        
        //Logic to calculate sum of diagonal2
        int sumOfDiagonal2=0;
        for (int i=0,j=n-1 ; i<n && j>=0 ; i++, j--) {
               sumOfDiagonal2= sumOfDiagonal2 + a[i][j];
               
        }
        
        System.out.println(sumOfDiagonal1+sumOfDiagonal2);
        
    }
}
        
       
        
    
    
    