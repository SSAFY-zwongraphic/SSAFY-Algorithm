package baekjoon.d_0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2579_fail {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			System.out.println(stair[1]);
		}

		if (n == 2) {
			System.out.println(stair[1] + stair[2]);
		}

		if (n >= 3) {
			Sum result[] = new Sum[n + 1];
			result[n] = new Sum(stair[n], true);
			result[n - 1] = new Sum(stair[n] + stair[n - 1], false);
			result[n - 2] = new Sum(stair[n] + stair[n - 2], true);

			for (int i = n - 3; i > 0; i--) {
				if (!result[i + 1].possible) {
					int r1 = result[i + 2].score + stair[i];
					int r2 = result[i + 1].score;

					if (r1 >= r2) {
						result[i] = new Sum(r1, true);
					} else {
						result[i] = new Sum(r2, true);
					}

				} else {
					int r1 = result[i + 2].score + stair[i];
					int r2 = result[i + 1].score + stair[i];

					if ((r1 + stair[i - 1]) >= r2) {
						result[i] = new Sum(r1, true);
					} else {
						result[i] = new Sum(r2, false);
					}
				}
			}

			int r = Math.max(result[1].score, result[2].score);
			System.out.println(r);
		}
	}
}

class Sum {
	int score;
	boolean possible;

	public Sum(int score, boolean possible) {
		this.score = score;
		this.possible = possible;
	}
}