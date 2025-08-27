package swea.d_0826;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1249 {
	// 0: 상, 1:하, 2: 좌, 3: 우
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n;
	private static int[][] map;
	private static int[][] distance;
	private static int min;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("swea/d_0826/input1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			distance = new int[n][n];
			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}

			System.out.printf("#%d %d\n", t, t);
		}
	}

	private static void dijkstra() {
	}
}
