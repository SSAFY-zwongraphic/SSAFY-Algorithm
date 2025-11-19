package baekjoon.d_1118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17086 {

	public static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static int n, m;
	public static int[][] space;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		space = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					Arrays.fill(visited[k], false);
				}
				result = Math.max(result, bfs(i, j, visited));
			}
		}

		System.out.println(result);

	}

	public static int bfs(int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { x, y, 0 });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			int distance = current[2];

			if (space[currentX][currentY] == 1) {
				return distance;
			}

			for (int i = 0; i < 8; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}

				if (!visited[nextX][nextY]) {
					queue.offer(new int[] { nextX, nextY, distance + 1 });
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return 0;
	}
}
