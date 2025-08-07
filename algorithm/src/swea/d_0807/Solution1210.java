package swea.d_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1210 {
	public static int[][] ladder;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int T = 0; T < 10; T++) {
			int t = Integer.parseInt(br.readLine());
			ladder = new int[100][102];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < 101; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i < 101; i++) {
				if (ladder[99][i] == 2) {
					move(99, i, "left");
				}
			}

			System.out.printf("#%d %d\n", t, result - 1);
		}
	}

	public static void move(int x, int y, String direction) {
		if (x == 0) {
			result = y;
			return;
		}

		if (ladder[x - 1][y] == 1 && direction.equals("right")) {
			move(x - 1, y, "up");
		} else if (ladder[x - 1][y] == 1 && direction.equals("left")) {
			move(x - 1, y, "up");
		} else if (ladder[x][y - 1] == 1 && !direction.equals("right")) {
			move(x, y - 1, "left");
		} else if (ladder[x][y + 1] == 1) {
			move(x, y + 1, "right");
		} else if (ladder[x - 1][y] == 1) {
			move(x - 1, y, "up");
		}
	}
}
