package swea.d_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//D2
public class Solution2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] N = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					N[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					sum += N[i][j];
				}
			}

			int max = sum;
			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					for (int k = 0; k < m; k++) {
						sum += N[k][j + m];
						sum -= N[k][j];
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println(max);
		}
	}
}
