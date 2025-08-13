package baekjoon.d_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int lecture[] = new int[n];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			start = Math.max(start, lecture[i]);
			end += lecture[i];
		}

		int bluray = 0;
		while (start <= end) {
			bluray = (start + end) / 2;

			int sum = 0;
			int count = 1;
			for (int i = 0; i < n; i++) {
				if (sum + lecture[i] <= bluray) {
					sum += lecture[i];
				} else {
					count++;
					sum = lecture[i];
				}
			}
			if (count > m) {
				start = bluray + 1;
			} else {
				end = bluray - 1;
			}
		}

		System.out.println(start);
	}
}
