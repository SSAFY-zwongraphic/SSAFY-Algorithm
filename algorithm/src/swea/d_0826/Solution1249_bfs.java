package swea.d_0826;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1249_bfs {
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n;
	private static int[][] map;
	private static int[][] distance;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/d_0826/input1249.txt"));
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
			distance = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			move();

			System.out.printf("#%d %d\n", t, distance[n - 1][n - 1]);
		}
	}

	private static void move() {
		Queue<Integer[]> queue = new ArrayDeque<>();

		distance[0][0] = 0;
		queue.offer(new Integer[] { 0, 0 });

		while (!queue.isEmpty()) {
			Integer[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				int nextDistance = distance[x][y] + map[nx][ny];

				if (distance[nx][ny] > nextDistance) {
					distance[nx][ny] = nextDistance;
					queue.offer(new Integer[] { nx, ny });
				}
			}
		}
	}
}
