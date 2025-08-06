package baekjoon.d_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution11725 {
	public static ArrayList<Integer>[] tree;
	public static boolean[] visited;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			tree[n1].add(n2);
			tree[n2].add(n1);
		}

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				DFS(i);
			}
		}

		for (int i = 2; i < n + 1; i++) {
			System.out.println(parent[i]);
		}
	}

	public static void DFS(int i) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		for (int j : tree[i]) {
			if (!visited[j]) {
				parent[j] = i;
				DFS(j);
			}
		}
	}
}
