package baekjoon.d_0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] schedule = new int[2][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			schedule[0][i] = t;
			schedule[1][i] = p;
		}

		int[] result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int t = schedule[0][n - i + 1];
			int p = schedule[1][n - i + 1];

			if (i < t) {
				result[i] = result[i - 1];
			} else {
				result[i] = Math.max(result[i - 1], p + result[i - t]);
			}
		}

		System.out.println(result[n]);
	}
}
