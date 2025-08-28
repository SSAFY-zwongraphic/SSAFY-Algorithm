package baekjoon.d_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1753 {
	public static int v, e, k; // 노드수, 엣지수, 출발노드
	public static int distance[]; // 거리배열
	public static boolean visited[]; // 방문배열
	public static ArrayList<Edge> list[]; //
	public static PriorityQueue<Edge> q = new PriorityQueue<>(); //

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		distance = new int[v + 1];
		visited = new boolean[v + 1];
		list = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(v, w));
		}

		q.add(new Edge(k, 0));
		distance[k] = 0;
		while (!q.isEmpty()) {
			Edge current = q.poll();
			int currentVertex = current.vertex;
			if (visited[currentVertex])
				continue;
			visited[currentVertex] = true;
			for (int i = 0; i < list[currentVertex].size(); i++) {
				Edge temp = list[currentVertex].get(i);
				int nextVertex = temp.vertex;
				int value = temp.value;
				if (distance[nextVertex] > distance[currentVertex] + value) {
					distance[nextVertex] = distance[currentVertex] + value;
					q.add(new Edge(nextVertex, distance[nextVertex]));
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			if (visited[i]) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int vertex, value;

	Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}

	public int compareTo(Edge e) {
		if (this.value > e.value)
			return 1;
		else
			return -1;
	}
}
