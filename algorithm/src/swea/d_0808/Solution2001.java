package swea.d_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] nn = new int[n + 1][n + 1];
			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n + 1; j++) {
					nn[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] nnSum = new int[n + 1][n + 1];
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					nnSum[i][j] = nnSum[i - 1][j] + nnSum[i][j - 1] - nnSum[i - 1][j - 1] + nn[i][j];
				}
			}

			int max = 0;
			for (int i = m; i < m + (n - m + 1); i++) {
				int sum = 0;
				for (int j = m; j < m + (n - m + 1); j++) {
					sum = nnSum[i][j] - nnSum[i - m][j] - nnSum[i][j - m] + nnSum[i - m][j - m];
					max = Math.max(max, sum);
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
		}
	}
}
