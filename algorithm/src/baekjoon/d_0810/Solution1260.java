package baekjoon.d_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS: Stack, BFS: Queue 구현해보기
public class Solution1260 {
	public static ArrayList<Integer>[] graph;
	public static boolean[] visitedDfs;
	public static boolean[] visitedBfs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		visitedDfs = new boolean[n + 1];
		visitedBfs = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		for (int i = 1; i < n + 1; i++) {
			Collections.sort(graph[i]);
		}

		dfs(v);
		bfs(v);
	}

	public static void dfs(int v) {
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		stack.push(v);

		while (!stack.isEmpty()) {
			int u = stack.pop();

			if (!visitedDfs[u]) {
				visitedDfs[u] = true;
				sb.append(u).append(" ");
			}

			for (int i = graph[u].size() - 1; i >= 0; i--) {
				int next = graph[u].get(i);
				if (!visitedDfs[next]) {
					stack.push(next);
				}
			}
		}

		System.out.println(sb);

	}

	public static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		visitedBfs[v] = true;
		queue.offer(v);

		while (!queue.isEmpty()) {
			int u = queue.poll();
			sb.append(u).append(" ");

			for (int i = 0; i < graph[u].size(); i++) {
				int next = graph[u].get(i);
				if (!visitedBfs[next]) {
					visitedBfs[next] = true;
					queue.offer(next);
				}
			}
		}

		System.out.println(sb);
	}
}
