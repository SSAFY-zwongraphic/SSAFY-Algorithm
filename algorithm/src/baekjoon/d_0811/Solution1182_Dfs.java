package baekjoon.d_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1182_Dfs {
	private static int n, s;
	private static int[] arr;
	private static boolean[] isSelected;
	private static int sum = 0;
	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		isSelected = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		subset(0);
		if (s == 0) {
			result -= 1;
		}
		System.out.println(result);
	}

	private static void subset(int count) {
		if (count == n) {
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					sum += arr[i];
				}
			}
			if (sum == s) {
				result++;
			}
			sum = 0;
			return;
		}

		isSelected[count] = true;
		subset(count + 1);

		isSelected[count] = false;
		subset(count + 1);
	}
}
