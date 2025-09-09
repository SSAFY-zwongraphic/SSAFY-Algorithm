package baekjoon.d_0908;

import java.util.Scanner;

public class Solution1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] result = new int[n + 1];
		result[1] = 0;

		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int r1 = Integer.MAX_VALUE;
			int r2 = Integer.MAX_VALUE;
			int r3 = Integer.MAX_VALUE;

			r1 = result[i - 1] + 1;

			if (i % 2 == 0) {
				r2 = result[i / 2] + 1;
			}

			if (i % 3 == 0) {
				r3 = result[i / 3] + 1;
			}

			min = Math.min(r1, r2);
			min = Math.min(min, r3);

			result[i] = min;
		}

		System.out.println(result[n]);
	}
}