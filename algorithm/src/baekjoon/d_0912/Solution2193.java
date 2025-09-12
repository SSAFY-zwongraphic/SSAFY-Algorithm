package baekjoon.d_0912;

import java.util.Scanner;

public class Solution2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] prinary = new long[n + 1];

		prinary[1] = 1;
		long current0 = 0;
		long current1 = 1;

		for (int i = 2; i <= n; i++) {
			long next0 = current0 + current1;
			long next1 = current0;

			prinary[i] = next0 + next1;
			current0 = next0;
			current1 = next1;
		}

		System.out.println(prinary[n]);
	}
}
