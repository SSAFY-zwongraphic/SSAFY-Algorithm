package baekjoon.d_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int[] balloon;
	private static boolean[] burst;
	private static int maxScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			maxScore = 0;
			n = Integer.parseInt(br.readLine());
			balloon = new int[n + 2];
			burst = new boolean[n + 2];
			burst[0] = true;
			burst[n + 1] = true;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				balloon[i] = Integer.parseInt(st.nextToken());
			}

			burstBalloon(0, 0, 0);

			System.out.println("#" + t + " " + maxScore);
		}
	}

	private static void burstBalloon(int current, int count, int score) {
		if (count == n) {
			if (score > maxScore) {
				maxScore = score;
			}
		}

		for (int i = 1; i <= n; i++) {
			int nextScore = score;
			if (!burst[i]) {
				burst[i] = true;

				if (checkLeft(i) == 0 && checkRight(i) == 0) {
					nextScore += balloon[i];
				} else if (checkLeft(i) == 0 && checkRight(i) != 0) {
					nextScore += checkRight(i);
				} else if (checkLeft(i) != 0 && checkRight(i) == 0) {
					nextScore += checkLeft(i);
				} else if (checkLeft(i) != 0 && checkRight(i) != 0) {
					nextScore += (checkLeft(i) * checkRight(i));
				}

				burstBalloon(i, count + 1, nextScore);

				burst[i] = false;
			}
		}
	}

	private static int checkLeft(int current) {
		for (int i = current; i > 0; i--) {
			if (!burst[i]) {
				return balloon[i];
			}
		}
		return 0;
	}

	private static int checkRight(int current) {
		for (int i = current; i <= n; i++) {
			if (!burst[i]) {
				return balloon[i];
			}
		}
		return 0;
	}
}
