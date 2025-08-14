package swea.d_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int op[] = new int[n - 1];
			int opIndex = 0;
			int plusNum = Integer.parseInt(st.nextToken());
			for (int i = 0; i < plusNum; i++) {
				op[opIndex++] = 0;
			}
			int minusNum = Integer.parseInt(st.nextToken());
			for (int i = 0; i < minusNum; i++) {
				op[opIndex++] = 1;
			}
			int multiNum = Integer.parseInt(st.nextToken());
			for (int i = 0; i < multiNum; i++) {
				op[opIndex++] = 2;
			}
			int divNum = Integer.parseInt(st.nextToken());
			for (int i = 0; i < divNum; i++) {
				op[opIndex++] = 3;
			}
			st = new StringTokenizer(br.readLine());
			int num[] = new int[n];
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			int result;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			do {
				result = num[0];
				
				for (int i = 0; i < op.length; i++) {
					switch (op[i]) {
					case 0:
						result = result + num[i + 1];
						break;
					case 1:
						result = result - num[i + 1];
						break;
					case 2:
						result = result * num[i + 1];
						break;
					case 3:
						result = result / num[i + 1];
						break;
					}
				}

				if (result > max) {
					max = result;
				}

				if (result < min) {
					min = result;
				}
			} while (nextPermutation(op));

			System.out.printf("#%d %d\n", t, max - min);
		}
	}

	private static boolean nextPermutation(int[] op) {
		int i = op.length - 1;
		while (op[i - 1] >= op[i]) {
			i--;

			if (i == 0) {
				return false;
			}
		}

		int j = op.length - 1;
		while (op[i - 1] >= op[j]) {
			j--;
		}

		int temp = op[i - 1];
		op[i - 1] = op[j];
		op[j] = temp;

		Arrays.sort(op, i, op.length);

		return true;
	}
}
