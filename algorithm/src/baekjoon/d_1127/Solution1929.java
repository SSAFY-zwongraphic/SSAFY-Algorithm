package baekjoon.d_1127;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int[] nums = new int[n + 1];
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);

		for (int num = 1; num <= n; num++) {
			nums[num] = num;
		}

		prime[1] = false;
		for (int i = 2; i <= Math.sqrt(n); i++) {

			if (!prime[i]) {
				continue;
			}

			for (int j = i * i; j <= n; j += i) {
				if (j % i == 0) {
					prime[j] = false;
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int num = m; num <= n; num++) {
			if (prime[num]) {
				sb.append(num + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
