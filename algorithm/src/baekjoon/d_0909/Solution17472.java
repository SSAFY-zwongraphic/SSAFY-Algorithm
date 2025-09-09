package baekjoon.d_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution17472 {
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n, m;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<int[]>[] island;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		island = new ArrayList[6];
		for (int i = 0; i < 6; i++) {
			island[i] = new ArrayList<>();
		}
		visited = new boolean[n + 2][n + 2];
		int islandNum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					setIsland(i, j, islandNum);
					islandNum++;

				}
			}
		}
	}

	private static void setIsland(int x, int y, int n) {
		island[n].add(new int[] { x, y });

		while (true) {
			
		}
	}
}
