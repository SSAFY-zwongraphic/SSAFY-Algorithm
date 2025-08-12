package baekjoon.d_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		int target[] = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		for (int i : target) {
			boolean existed = false;
			int start = 0;
			int end = a.length - 1;
			while (!(start > end)) {
				int mid = (start + end) / 2;

				if (i > a[mid]) {
					start = mid + 1;
				} else if (i < a[mid]) {
					end = mid - 1;
				} else if (i == a[mid]) {
					existed = true;
					break;
				}
			}

			if (existed) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}
}
