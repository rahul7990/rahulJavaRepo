package com.test;

public class StringTest2 {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "efgh";
		System.out.println(mergeStrings(s1, s2));
	}

	private static char[] mergeStrings(String s1, String s2) {

		int i = 0, j = 0, k = 0, m = 0;

		int counter = 0;
		int l1 = s1.length();
		int l2 = s2.length();

		char[] arr = new char[l1 + l2];

		if (l1 < l2)
			counter = l1;
		else
			counter = l2;

		while (m < counter) {
			arr[i++] = s1.charAt(j++);
			arr[i++] = s2.charAt(k++);
			m++;
		}

		while (k < l2) {
			arr[i++] = s2.charAt(k++);
		}

		while (j < l1) {
			arr[i++] = s1.charAt(j++);
		}
		return arr;

	}
}
