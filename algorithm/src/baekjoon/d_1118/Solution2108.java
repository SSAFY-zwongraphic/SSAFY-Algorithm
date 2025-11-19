package baekjoon.d_1118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] N = new int[n];

		int sum = 0;

		int[][] freq = new int[2][4001];

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			N[i] = Integer.parseInt(br.readLine());

			sum += N[i];

			if (N[i] < 0) {
				freq[0][Math.abs(N[i])]++;
			} else {
				freq[1][Math.abs(N[i])]++;
			}

			max = Math.max(max, N[i]);
			min = Math.min(min, N[i]);
		}

		Arrays.sort(N);

		double result1 = (double) sum / n;

		int result2 = N[n / 2];

		int result3 = 0;

		int maxFreq = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4001; j++) {
				maxFreq = Math.max(maxFreq, freq[i][j]);
			}
		}

		int count = 0;
		for (int i = 4000; i > 0; i--) {
			if (freq[0][i] == maxFreq) {
				result3 = -1 * i;
				count++;
			}

			if (count == 2) {
				break;
			}
		}

		if (count < 2) {
			for (int i = 0; i < 4001; i++) {
				if (freq[1][i] == maxFreq) {
					result3 = i;
					count++;
				}

				if (count == 2) {
					break;
				}
			}
		}

		int result4 = max - min;

		System.out.println(Math.round(result1));
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
}
