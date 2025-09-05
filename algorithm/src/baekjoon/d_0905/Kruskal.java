package baekjoon.d_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		// 가중치에 양수, 음수가 섞이면 오버/언더플로우 발생할 수 있어서 무조건 빼기로 하지는 않기
		// 사실 지금같은 경우에는 빼기로 구현해도 문제없음
//		return this.weight - e.weight;
		return Integer.compare(this.weight, e.weight);
	}
}

public class Kruskal {
	private static Edge[] edgeList;
	private static int[] parent;
	private static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		edgeList = new Edge[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgeList);

		int result = 0; // 최소신장트리 비용(가중치 합)
		int count = 0;
		for (Edge e : edgeList) {
			int from = e.from;
			int to = e.to;
			int weight = e.weight;

			if (!union(from, to)) {
				continue;
			} else {
				result += weight;
				count++;
			}

			if (count == n - 1) {
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
