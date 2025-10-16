package baekjoon.d_1016;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int count = 0;
		int result = 0;

		boolean prime[] = new boolean[n + 1];
		Arrays.fill(prime, true);

		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				for (int j = 1; i * j <= n; j++) {
					if (prime[i * j]) {
						prime[i * j] = false;
						count++;
					}

					if (count == k) {
						result = i * j;
						break;
					}
				}
			}

			if (result != 0) {
				break;
			}
		}

		System.out.println(result);
	}
}
