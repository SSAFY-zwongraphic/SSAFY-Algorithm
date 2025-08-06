package baekjoon.d_0806;

import java.util.Scanner;

public class Solution15649 {
	public static int n;
	public static int m;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			DFS(i, 1);
		}
	}

	public static void DFS(int num, int depth) {
		System.out.print(num + " ");

		if (depth == m) {
			System.out.println();
			return;
		}

		visited[num] = true;

		if (depth < m) {
			for (int i = 1; i < n + 1; i++) {
				if (!visited[i]) {
					DFS(i, depth + 1);
				}
			}
		}

		visited[num] = false;
	}
}
