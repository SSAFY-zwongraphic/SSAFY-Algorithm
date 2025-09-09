package baekjoon.d_0909;

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
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
	}

	@Override
	public int compareTo(Edge e) {
		return this.distance - e.distance;
	}
}

public class Solution17472 {
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n, m;
	private static int[][] map;
	private static boolean[][] visited;
	private static List<int[]>[] island;
	private static List<Edge> bridge;
	private static int[] parent;

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

		visited = new boolean[n + 2][m + 2];

		island = new ArrayList[7];

		for (int i = 1; i <= 6; i++) {
			island[i] = new ArrayList<>();
		}

		int islandNum = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1 && (!visited[i][j])) {
					islandNum++;
					setIsland(i, j, islandNum);
				}
			}
		}

		bridge = new ArrayList<>();

		for (int i = 1; i <= 6; i++) {
			if (!island[i].isEmpty()) {
				setBridge(island[i], i);
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

//		섬이 잘 세팅됐는지 확인하는용 (1)
//		for (ArrayList<int[]> a : island) {
//			for (int i = 0; i < a.size(); i++) {
//				int x = a.get(i)[0];
//				int y = a.get(i)[1];
//				System.out.println(x + " " + y);
//			}
//			System.out.println();
//		}

//		섬이 잘 세팅됐는지 확인하는용 (2)
//		for (int[] row : map) {
//			for (int col : row) {
//				System.out.print(col);
//			}
//			System.out.println();
//		}

//		다리 잘 세팅됐는지 확인하는용
//		for (Edge e : bridge) {
//			System.out.println(e.from + " " + e.to + " " + e.distance);
//		}
	}

	private static void setIsland(int x, int y, int num) {
		island[num].add(new int[] { x, y });
		visited[x][y] = true;
		map[x][y] = num;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (map[nx][ny] == 1 && (!visited[nx][ny])) {
				setIsland(nx, ny, num);
			}
		}
	}

	private static void setBridge(List<int[]> a, int num) {
		for (int i = 0; i < a.size(); i++) {
			int x = a.get(i)[0];
			int y = a.get(i)[1];

			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				boolean possible = true;
				int distance = 0;
				int to = 0;
				while (true) {
					if (map[nx][ny] == num) {
						possible = false;
						break;
					}

					if (nx < 1 || nx > n || ny < 1 || ny > m) {
						possible = false;
						break;
					}

					if (!(map[nx][ny] == 0 || map[nx][ny] == num)) {
						to = map[nx][ny];
						break;
					}

					distance++;
					nx += dx[j];
					ny += dy[j];
				}

				if (possible && distance >= 2) {
					bridge.add(new Edge(num, to, distance));
				}
			}
		}
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
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
}
