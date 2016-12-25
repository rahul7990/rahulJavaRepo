package com.string.java;

import java.util.Arrays;

public class NextLargestNumber {

	
	private static int findNextLargest(int number) {
        int[] digits = getDigits(number);
 
        int rightIndex = -1;
        int leftIndex = -1;
 
        // Find the indices of the digits to be swapped.//1 2 3 5 4
        for (int i = digits.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (digits[i] > digits[j]) {
 
                    if (rightIndex == -1) {
                        rightIndex = i;
                        leftIndex = j;
                    } else if (leftIndex < j && rightIndex > i) {
                        rightIndex = i;
                        leftIndex = j;
                    }
                    break;
                }
            }
        }
 
        if (rightIndex == -1)
            throw new RuntimeException(
                    "Not possible to make next greater number. Input number is the greatest number that can be formed from the digits.");
 
        swap(digits, rightIndex, leftIndex);
        sort(digits, leftIndex + 1);
        return formNumber(digits);
    }
 
    private static int[] getDigits(int number) {
 
        int[] digitsArr = new int[String.valueOf(number).length()];
 
        int index = digitsArr.length - 1;
        while (number > 0) {
            digitsArr[index--] = number % 10;
            number = number / 10;
        }
        return digitsArr;
    }
 
    private static void swap(int[] digits, int rightIndex, int leftIndex) {
        int temp = digits[rightIndex];
        digits[rightIndex] = digits[leftIndex];
        digits[leftIndex] = temp;
    }
 
    private static void sort(int[] digits, int startIndex) {
        int endIndex = digits.length;
 
        if (startIndex == endIndex)
            return;
 
        // Sort array from start index to end index
        Arrays.sort(digits, startIndex, endIndex);
    }
 
    private static int formNumber(int[] digits) {
        int digit = 0;
 
        int size = digits.length;
 
        for (int i = 0; i < size; i++)
            digit = digit * 10 + digits[i];
 
        return digit;
    }
 
    public static void main(String[] args) {
        int number = 12354;
        System.out.println("Input number is:        " + number);
 
        try {
            int nextLargest = findNextLargest(number);
            System.out.println("Next largest number is: " + nextLargest);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
