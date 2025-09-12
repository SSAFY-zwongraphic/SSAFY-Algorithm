package baekjoon.d_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int from, to, distance;

	public Edge(int from, int to, int distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}

	@Override
	public int compareTo(Edge e) {
		return this.distance - e.distance;
	}
}

public class Solution17472_refact {
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n, m;
	private static int[][] map;
	private static boolean[][] visited;
	private static List<Edge> bridge;
	private static int[] parent;

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		int islandNum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && (!visited[i][j])) {
					islandNum++;
					setIsland(i, j, islandNum);
				}
			}
		}

		bridge = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					setBridge(i, j, map[i][j]);
				}
			}
		}

		Collections.sort(bridge);

		parent = new int[islandNum + 1];
		for (int i = 1; i <= islandNum; i++) {
			parent[i] = i;
		}

		int count = 0;
		int result = 0;
		for (Edge e : bridge) {
			int from = e.from;
			int to = e.to;
			int distance = e.distance;

			if (union(from, to)) {
				count++;
				result += distance;
			}

			if (count == islandNum - 1) {
				break;
			}
		}

		if (count != islandNum - 1) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void setIsland(int x, int y, int num) {
		visited[x][y] = true;
		map[x][y] = num;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}

			if (map[nx][ny] == 1 && (!visited[nx][ny])) {
				setIsland(nx, ny, num);
			}
		}
	}

	private static void setBridge(int x, int y, int num) {
		for (int j = 0; j < 4; j++) {
			int nx = x + dx[j];
			int ny = y + dy[j];

			int distance = 0;
			int to = 0;
			while (true) {
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					break;
				}

				if (map[nx][ny] == num) {
					break;
				}

				if (map[nx][ny] != 0) {
					to = map[nx][ny];
					break;
				}

				distance++;
				nx += dx[j];
				ny += dy[j];
			}

			if (to != 0 && distance >= 2) {
				bridge.add(new Edge(num, to, distance));
			}
		}
	}

	private static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY) {
			return false;
		}

		if (rootX > rootY) {
			parent[rootX] = rootY;
		} else {
			parent[rootY] = rootX;
		}

		return true;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}
}
