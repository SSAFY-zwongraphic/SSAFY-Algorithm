package baekjoon.d_0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4963 {
	private static int[][] island;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0)
				break;

			island = new int[h + 2][w + 2];
			for (int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (island[i][j] == 1) {
						count++;
						bfs(i, j);
					}
				}
			}
			
			System.out.println(count);
		}
	}

	private static void bfs(int x, int y) {
		if (island[x][y] == 0) {
			return;
		}

		island[x][y] = 0;

		if (island[x - 1][y - 1] == 1) {
			bfs(x - 1, y - 1);
		}
		if (island[x - 1][y] == 1) {
			bfs(x - 1, y);
		}
		if (island[x - 1][y + 1] == 1) {
			bfs(x - 1, y + 1);
		}
		if (island[x][y + 1] == 1) {
			bfs(x, y + 1);
		}
		if (island[x + 1][y + 1] == 1) {
			bfs(x + 1, y + 1);
		}
		if (island[x + 1][y] == 1) {
			bfs(x + 1, y);
		}
		if (island[x + 1][y - 1] == 1) {
			bfs(x + 1, y - 1);
		}
		if (island[x][y - 1] == 1) {
			bfs(x, y - 1);
		}
	}
}
