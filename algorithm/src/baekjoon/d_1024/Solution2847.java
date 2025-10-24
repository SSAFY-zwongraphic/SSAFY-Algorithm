package baekjoon.d_1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];
		int result = 0;

		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		int last = score.length - 1;
		for (int i = last - 1; i >= 0; i--) {
			while (score[i] >= score[i + 1]) {
				score[i]--;
				result++;
			}
		}
		
		System.out.println(result);
	}
}
