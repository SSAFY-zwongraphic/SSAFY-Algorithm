package baekjoon.d_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution11724_Book {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				DFS(i);
				count++;
			}
		}

		System.out.println(count);
	}

	public static void DFS(int i) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		for (int j : graph[i]) {
			if (!visited[j]) {
				DFS(j);
			}
		}
	}
}
