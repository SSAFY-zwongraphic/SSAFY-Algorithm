package baekjoon.d_1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11404 {
	public static final int INF = 10000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cityNum = Integer.parseInt(br.readLine());
		int busNum = Integer.parseInt(br.readLine());

		int[][] result = new int[cityNum + 1][cityNum + 1];
		
		for (int i = 1; i <= cityNum; i++) {
			for (int j = 1; j <= cityNum; j++) {
				if (i == j) {
					result[i][j] = 0;
				} else {
					result[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < busNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			result[a][b] = Math.min(result[a][b], c);
			;
		}

		for (int k = 1; k <= cityNum; k++) {
			for (int i = 1; i <= cityNum; i++) {
				for (int j = 1; j <= cityNum; j++) {
					result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
				}
			}
		}

		for (int i = 1; i <= cityNum; i++) {
			for (int j = 1; j <= cityNum; j++) {
				if (result[i][j] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}