package swea.d_0902;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int x;
	int y;
	int dist;

	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	public int compareTo(Node n) {
		return this.dist - n.dist;
	}
}

public class Solution1249_dijikstra {
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
					distance[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra();

			System.out.printf("#%d %d\n", t, distance[n - 1][n - 1]);

		}
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		distance[0][0] = 0;
		pq.offer(new Node(0, 0, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int x = current.x;
			int y = current.y;
			int dist = current.dist;

			if (dist > distance[x][y]) {
				continue;
			}

			if (x == n - 1 && y == n - 1) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}

				int nextDist = dist + map[nx][ny];

				if (distance[nx][ny] > nextDist) {
					distance[nx][ny] = nextDist;
					pq.offer(new Node(nx, ny, nextDist));
				}
			}
		}
	}
}
