package baekjoon.d_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		int[][] adj = new int[v][v];
		boolean[] visited = new boolean[v];
		int[] minEdge = new int[v];

		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < v; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;

		int result = 0;
		int c = 0;
		for (; c < v; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < v; i++) {
				if (visited[i])
					continue;
				if (minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			if (minVertex == -1)
				break;
			result += minEdge[minVertex];
			visited[minVertex] = true;

			for (int i = 0; i < v; i++) {
				if (!visited[i] && adj[minVertex][i] != 0) {
					if (minEdge[i] > adj[minVertex][i]) {
						minEdge[i] = adj[minVertex][i];
					}
				}
			}
		}

		System.out.println(c == v ? result : -1);
	}

}
