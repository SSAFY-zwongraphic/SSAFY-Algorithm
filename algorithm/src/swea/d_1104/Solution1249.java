package swea.d_1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1249 {
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static int n;
	public static Node[][] map;
	public static int[][] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new Node[n][n];
			cost = new int[n][n];

			for (int[] i : cost) {
				Arrays.fill(i, Integer.MAX_VALUE);
			}

			for (int i = 0; i < n; i++) {
				String s = br.readLine();

				for (int j = 0; j < n; j++) {
					map[i][j] = new Node(i, j, s.charAt(j) - '0');
				}
			}

			dijkstra();

			System.out.println("#" + t + " " + cost[n - 1][n - 1]);
		}
	}

	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		cost[0][0] = 0;
		pq.offer(new Node(0, 0, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int x = node.x;
			int y = node.y;
			int depth = node.depth;

			if (x == n - 1 && y == n - 1) {
				return;
			}
			
			if (cost[x][y] < depth) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}

				if (cost[x][y] + map[nx][ny].depth < cost[nx][ny]) {
					cost[nx][ny] = cost[x][y] + map[nx][ny].depth;
					pq.offer(new Node(nx, ny, cost[nx][ny]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int x, y, depth;

	public Node(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}

	@Override
	public int compareTo(Node n) {
		return this.depth - n.depth;
	}
}
