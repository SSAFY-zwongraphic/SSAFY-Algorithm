package baekjoon.d_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge2 implements Comparable<Edge2> {
	int a, b, w;

	public Edge2(int a, int b, int w) {
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Edge2 e) {
		return Integer.compare(this.w, e.w);
	}
}

public class Solution1197 {
	private static Edge2[] edges;
	private static int[] parent;
	private static int v, e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		parent = new int[v + 1];
		edges = new Edge2[e];

		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge2(a, b, w);
		}
		
		Arrays.sort(edges);

		int count = 0;
		int result = 0;
		for (Edge2 e : edges) {
			int a = e.a;
			int b = e.b;
			int w = e.w;

			if (!union(a, b)) {
				continue;
			}

			count++;
			result += w;

			if (count == v - 1) {
				break;
			}
		}

		System.out.println(result);
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return false;
		}

		if (rootA > rootB) {
			parent[rootA] = rootB;
		} else {
			parent[rootB] = rootA;
		}

		return true;
	}
}
