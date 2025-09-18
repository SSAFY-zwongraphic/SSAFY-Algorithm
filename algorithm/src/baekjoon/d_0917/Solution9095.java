package baekjoon.d_0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9095 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int dp[] = new int[N + 3];

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int n = 4; n <= N; n++) {
				dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
			}

			System.out.println(dp[N]);
		}
	}
}
