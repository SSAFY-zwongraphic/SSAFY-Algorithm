package baekjoon.d_1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] score = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				score[index] = value;
			}

			int max = score[1];
			int possible = 1;;
			for (int i = 2; i <= n; i++) {
				if (score[i] < max) {
					possible++;
					max = score[i];
				}
			}
			
			System.out.println(possible);
		}
	}
}
