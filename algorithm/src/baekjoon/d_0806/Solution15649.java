package baekjoon.d_0806;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution15649 {
	public static int n;
	public static int m;
	public static boolean[] visited;
	public static ArrayList<Integer> result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n + 1];
		result = new ArrayList<>();

		DFS(1);
	}

	public static void DFS(int depth) {
		if (depth > m) {
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		if (depth <= m) {
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					result.add(i);
					visited[i] = true;
					DFS(depth + 1);
					visited[i] = false;
					result.remove(result.size() - 1);
				}
			}
		}
	}
}
