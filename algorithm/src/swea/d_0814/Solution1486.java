package swea.d_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution1486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int height[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			int subset = 0;
			ArrayList<Integer> result = new ArrayList<>();
			for (int i = 0; i < (1 << n); i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) != 0) {
						sum += height[j];
					}
				}

				if (sum >= b) {
					result.add(sum);
				}
			}

			Collections.sort(result);
			System.out.printf("#%d %d\n", t, result.get(0) - b);
		}
	}
}