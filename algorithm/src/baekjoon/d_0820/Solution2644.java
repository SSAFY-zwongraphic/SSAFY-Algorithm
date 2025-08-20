package baekjoon.d_0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2644 {
	private static ArrayList<Integer>[] parent;
	private static boolean[] visited;
	private static int start, end;
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parent = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = new ArrayList<>();
		}

		visited = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int human1 = Integer.parseInt(st.nextToken());
			int human2 = Integer.parseInt(st.nextToken());

			parent[human1].add(human2);
			parent[human2].add(human1);
		}

		result = 0;
		bfs(start, 0);
		
		if (result == 0) {
			System.out.println(-1);
		}
	}

	private static void bfs(int start, int count) {
		if (start == end) {
			result = count;
			System.out.println(result);
			return;
		}
		
		if (visited[start]) {
			return;
		}

		visited[start] = true;

		for (int i : parent[start]) {
			if (!visited[i]) {
				bfs(i, count + 1);
			}
		}
	}
}
