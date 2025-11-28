package baekjoon.d_1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution16173 {
	public static int n;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = { 0, 1 };
	public static int[] dy = { 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][n];

		boolean result = dfs(0, 0);

		if (result) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

	public static boolean dfs(int x, int y) {
		visited[x][y] = true;

		if (x == n - 1 && y == n - 1) {
			return true;
		}

		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i] * map[x][y];
			int ny = y + dy[i] * map[x][y];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}

			if (!visited[nx][ny]) {
				if (dfs(nx, ny)) {
					return true;
				}
			}

		}

		return false;
	}
}
