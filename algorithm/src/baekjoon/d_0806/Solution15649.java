package baekjoon.d_0806;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution15649 {
	public static ArrayList<Integer>[] tree;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		tree = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n; i++) {
			DFS(i);
		}
	}

	public static void DFS(int i) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		for (int j : tree[i]) {
			if (!visited[j]) {
				DFS(j);
			}
		}
	}
}
