package baekjoon.d_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] food = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << n); i++) {
			int s = 1;
			int b = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					s *= food[j][0];
					b += food[j][1];
				}
			}

			int taste = Math.abs(s - b);
			if (taste < min) {
				min = taste;
			}
		}
		
		System.out.println(min);
	}
}
