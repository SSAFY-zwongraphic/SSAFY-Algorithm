package baekjoon.d_1118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17086_refact {
	public static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] space = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (space[i][j] == 1) {
					queue.offer(new int[] { i, j, 0 });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			int distance = current[2];

			result = Math.max(result, distance);

			for (int i = 0; i < 8; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}

				if (space[nextX][nextY] == 0) {
					queue.offer(new int[] { nextX, nextY, distance + 1 });
					space[nextX][nextY] = distance + 1;
				}
			}
		}

		System.out.println(result);
	}
}
