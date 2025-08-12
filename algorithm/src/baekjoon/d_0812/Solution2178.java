package baekjoon.d_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2178 {
	static int n, m;
	static int[][] miro;
	static boolean[][] visited;
	static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		miro = new int[n + 2][m + 2];
		visited = new boolean[n + 1][m + 1];
		distance = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			for (int j = 1; j <= m; j++) {
				miro[i][j] = s.charAt(j - 1) - '0';
			}
		}

		bfs(1, 1);

		System.out.println(distance[n][m]);
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		visited[x][y] = true;
		distance[x][y] = 1;
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			x = temp[0];
			y = temp[1];

			if (x == n && y == m) {
				return;
			}

			if (miro[x - 1][y] == 1 && !visited[x - 1][y]) {
				visited[x - 1][y] = true;
				distance[x - 1][y] = distance[x][y] + 1;
				queue.offer(new int[] { x - 1, y });
			}
			if (miro[x + 1][y] == 1 && !visited[x + 1][y]) {
				visited[x + 1][y] = true;
				distance[x + 1][y] = distance[x][y] + 1;
				queue.offer(new int[] { x + 1, y });
			}
			if (miro[x][y - 1] == 1 && !visited[x][y - 1]) {
				visited[x][y - 1] = true;
				distance[x][y - 1] = distance[x][y] + 1;
				queue.offer(new int[] { x, y - 1 });
			}
			if (miro[x][y + 1] == 1 && !visited[x][y + 1]) {
				visited[x][y + 1] = true;
				distance[x][y + 1] = distance[x][y] + 1;
				queue.offer(new int[] { x, y + 1 });
			}
		}
	}
}
