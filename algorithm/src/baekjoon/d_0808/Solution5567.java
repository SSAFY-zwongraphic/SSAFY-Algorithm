package baekjoon.d_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution5567 {
	public static ArrayList<Integer>[] friend;
	public static int depth;
	public static boolean[] invited;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		friend = new ArrayList[n + 1];
		depth = 0;
		invited = new boolean[n + 1];
		count = 0;
		for (int i = 1; i <= n; i++) {
			friend[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			friend[f1].add(f2);
			friend[f2].add(f1);
		}
		invited[1] = true;
		dfs(1, 0);
		System.out.println(count);
	}

	public static void dfs(int num, int depth) {
		if (depth == 2) {
			return;
		}

		if (depth < 2) {
			for (int i : friend[num]) {
				if (!invited[i]) {
					count++;
					invited[i] = true;
					dfs(i, depth + 1);
				}
			}
		}
	}
}
