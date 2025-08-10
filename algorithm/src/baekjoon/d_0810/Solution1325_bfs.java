package baekjoon.d_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1325_bfs {
	public static ArrayList<Integer>[] graph;
	public static int run = 0;
	public static int[] visited;
	public static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			graph[c2].add(c1);
		}

		visited = new int[n + 1];
		count = new int[n + 1];
		int max = 0;
		for (int i = 1; i < n + 1; i++) {
			count[i] = bfs(i);
			if (count[i] > max) {
				max = count[i];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			if (count[i] == max) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}

	public static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		int count = 0;
		run++;

		visited[start] = run;
		queue.offer(start);

		while (!queue.isEmpty()) {
			start = queue.poll();

			for (int next : graph[start]) {
				if (visited[next] != run) {
					visited[next] = run;
					queue.offer(next);
					count++;
				}
			}
		}

		return count;
	}
}
