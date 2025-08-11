package baekjoon.d_0811;

import java.util.Scanner;

public class Solution2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;

		for (int i = 1; i < N; i++) {
			String s = String.valueOf(i);
			int n[] = new int[s.length()];
			int sum = i;
			for (int j = 0; j < s.length(); j++) {
				n[j] = s.charAt(j) - '0';
				sum += n[j];
			}
			if (sum == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
