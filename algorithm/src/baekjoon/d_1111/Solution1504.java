package baekjoon.d_1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1504 {
	public static final int INF = 800001;
	public static int n, e;
	public static ArrayList<Node>[] list;
	public static int[][] result;
	public static int v1, v2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		result = new int[3][n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Node>();
			result[0][i] = INF;
			result[1][i] = INF;
			result[2][i] = INF;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		dijkstra(1, 0);
		dijkstra(v1, 1);
		dijkstra(v2, 2);

		int result1 = result[0][v1] + result[1][v2] + result[2][n];
		int result2 = result[0][v2] + result[2][v1] + result[1][n];

		boolean impossible1 = result[0][v1] == INF || result[1][v2] == INF || result[2][n] == INF;
		boolean impossible2 = result[0][v2] == INF || result[2][v1] == INF || result[1][n] == INF;

		if (impossible1 && impossible2) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(result1, result2));
		}
	}

	public static void dijkstra(int depart, int row) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		result[row][depart] = 0;
		pq.offer(new Node(depart, 0));

		while (!pq.isEmpty()) {
			Node n = pq.poll();
			int node = n.node;
			int dist = n.dist;

			if (result[row][node] < dist) {
				continue;
			}

			for (Node next : list[node]) {
				int nextDist = result[row][node] + next.dist;
				if (nextDist < result[row][next.node]) {
					result[row][next.node] = nextDist;
					pq.offer(new Node(next.node, result[row][next.node]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {

	public int node;
	public int dist;

	public Node(int node, int dist) {
		super();
		this.node = node;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node n) {
		return this.dist - n.dist;
	}

}
