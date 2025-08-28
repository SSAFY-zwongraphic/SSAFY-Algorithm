package swea.d_0826;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//최단거리(다익스트라) 문제라 dfs로 푸는 건 비효율적이긴 함
public class Solution1249_dfs {
	// 0: 상, 1:하, 2: 좌, 3: 우
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n;
	private static int[][] map;
	private static int[][] distance;

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
			distance = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}

			distance[0][0] = 0;
			move(0, 0, 0);

			System.out.printf("#%d %d\n", t, distance[n - 1][n - 1]);
		}
	}

	private static void move(int x, int y, int currentDistance) {
		if (currentDistance > distance[x][y]) {
			return;
		}
		
		if ((x == n - 1) && (y == n - 1)) {	
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			
			int nextDistance = currentDistance + map[x][y];
			
			if (nextDistance < distance[nx][ny]) {
				distance[nx][ny] = nextDistance;
				move(nx, ny, distance[nx][ny]);
			}
		}
	}
}