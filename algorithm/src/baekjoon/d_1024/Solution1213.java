package baekjoon.d_1024;

import java.util.Scanner;

public class Solution1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		char[] palindrome = new char[name.length()];
		int[] alphabet = new int[26];
		int odd = 0;

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			alphabet[c - 'A']++;
		}

		int index = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] % 2 == 0) {
				for (int j = 0; j < alphabet[i] / 2; j++) {
					palindrome[index] = (char) ('A' + i);
					palindrome[name.length() - 1 - index] = (char) ('A' + i);
					index++;
				}
			}

			if (alphabet[i] % 2 == 1) {
				odd++;
				if (odd > 1) {
					break;
				}

				for (int j = 0; j < alphabet[i] / 2; j++) {
					palindrome[index] = (char) ('A' + i);
					palindrome[name.length() - 1 - index] = (char) ('A' + i);
					index++;
				}

				palindrome[palindrome.length / 2] = (char) ('A' + i);
			}
		}

		if (odd > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			for (char c : palindrome) {
				System.out.print(c);
			}
			System.out.println();
		}

		sc.close();
	}
}
