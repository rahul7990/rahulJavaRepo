package com.string.java;

public class RemoveMoreThan3Occurence {

	public static void main(String[] args) {
		String Actualstring = "";
		String str = "aaabbccfvdceefef";
		int count = 0;
		for (char i = 'a'; i < 'z'; i++) {
			count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == i)
					count++;
			}

			if (count >= 3) {
				Actualstring = str.replace(i, ' ');
				str = Actualstring;
			}

		}
		Actualstring = Actualstring.replaceAll(" ", "");
		System.out.println(Actualstring.trim());
	}
}
