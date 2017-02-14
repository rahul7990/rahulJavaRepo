package com.selection.algorithums;

public class MainFindWithPairComparison {

	private static void FindWithPairComparision(int array[], int n) {

		int large = -1;
		int small = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i = i + 2) {
			if (array[i] < array[i + 1]) {
				if (array[i] < small)
					small = array[i];
				if (array[i + 1] > large)
					large = array[i + 1];
			} else {
				if (array[i + 1] < small)
					small = array[i + 1];
				if (array[i] > large)
					large = array[i];
			}
		}

		System.out.println("Smallest : " + small + " Largest : " + large);

	}

	public static void main(String[] args) {
		int array[] = { 2, 5, 3, 11, 55, 33 };

		FindWithPairComparision(array, array.length);
	}
}
