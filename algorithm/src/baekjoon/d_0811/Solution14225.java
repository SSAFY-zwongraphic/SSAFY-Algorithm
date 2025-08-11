package baekjoon.d_0811;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution14225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}

		Set<Integer> sum = new TreeSet<>();
		for (int i = 1; i < (1 << n); i++) {
			int tmp = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					tmp += s[j];
				}
			}
			sum.add(tmp);
		}

		int index = 1;
		for (int i : sum) {
			if (i == index) {
				index++;
			}
		}

		System.out.println(index);
	}
}
