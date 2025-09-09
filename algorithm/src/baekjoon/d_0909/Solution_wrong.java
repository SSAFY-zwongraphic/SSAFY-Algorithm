package baekjoon.d_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_wrong {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> balloons = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				balloons.add(Integer.parseInt(st.nextToken()));
			}

			if (balloons.size() == 1) {
				System.out.println("#" + t + " " + balloon1(balloons));
			}

			if (balloons.size() == 2) {
				System.out.println("#" + t + " " + balloon2(balloons));
			}

			if (balloons.size() == 3) {
				System.out.println("#" + t + " " + balloon3(balloons));
			}

			if (balloons.size() > 3) {
				int sum = 0;
				while (true) {
					if (balloons.size() == 3) {
						sum += balloon3(balloons);
						break;
					}

					int max = 0;
					int index = 0;
					for (int i = 1; i < balloons.size() - 1; i++) {
						int tmp = balloons.get(i - 1) * balloons.get(i + 1);
						if (tmp > max) {
							max = tmp;
							index = i;
						}
					}
					sum += max;
					balloons.remove(index);
				}

				System.out.println("#" + t + " " + sum);
			}
		}
	}

	private static int balloon1(ArrayList<Integer> b) {
		return b.get(0);
	}

	private static int balloon2(ArrayList<Integer> b) {
		if (b.get(0) >= b.get(1)) {
			return b.get(0) * 2;
		} else {
			return b.get(1) * 2;
		}
	}

	private static int balloon3(ArrayList<Integer> b) {
		int max = 0;
		int c1 = b.get(0) * b.get(2);
		if (b.get(0) >= b.get(2)) {
			c1 += b.get(0) * 2;
		} else {
			c1 += b.get(2) * 2;
		}

		int c2 = b.get(1);
		int tmp = 0;
		if (b.get(0) >= b.get(2)) {
			tmp = b.get(0);
		} else {
			tmp = b.get(2);
		}
		if (b.get(1) >= tmp) {
			c2 += b.get(1) * 2;
		} else {
			c2 += tmp * 2;
		}

		max = Math.max(c1, c2);
		return max;
	}
}
