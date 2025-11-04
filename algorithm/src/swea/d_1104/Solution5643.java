package swea.d_1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution5643 {
	public static int n, m;
	public static ArrayList<Integer>[] tall;
	public static ArrayList<Integer>[] small;
	public static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());

			tall = new ArrayList[n + 1];
			small = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				tall[i] = new ArrayList<>();
				small[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				tall[a].add(b);
				small[b].add(a);
			}

			int possible = 0;

			for (int i = 1; i <= n; i++) {
				visited = new boolean[n + 1];
				int taller = dfs(i, tall) - 1;

				visited = new boolean[n + 1];
				int smaller = dfs(i, small) - 1;

				if (taller + smaller == n - 1) {
					possible++;
				}
			}

			System.out.println("#" + t + " " + possible);
		}
	}

	public static int dfs(int i, ArrayList<Integer>[] list) {
		visited[i] = true;
		int count = 1;

		for (int next : list[i]) {
			if (!visited[next]) {
				count += dfs(next, list);
			}
		}

		return count;
	}
}
