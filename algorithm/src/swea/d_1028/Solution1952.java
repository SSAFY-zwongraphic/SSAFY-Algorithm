package swea.d_1028;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1952 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/d_1028/input1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int threeMonth = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int plan[] = new int[13];
			for (int i = 1; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			int dp[] = new int[13];
			for (int i = 1; i < plan.length; i++) {
				int c1 = Integer.MAX_VALUE;
				int c2 = Integer.MAX_VALUE;
				c1 = Math.min(plan[i] * day, month) + dp[i - 1];

				if (i >= 3) {
					c2 = threeMonth + dp[i - 3];
				}

				dp[i] = Math.min(c1, c2);
			}

			dp[12] = Math.min(dp[12], year);

			System.out.println("#" + t + " " + dp[12]);
		}
	}
}
