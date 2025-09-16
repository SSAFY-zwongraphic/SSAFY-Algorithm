package baekjoon.d_0916;

import java.util.Scanner;

public class Solution10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int dp[][] = new int[101][10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];

			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}

		long result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result + dp[n][i]) % 1000000000;
		}
		
		System.out.println(result);
	}
}
