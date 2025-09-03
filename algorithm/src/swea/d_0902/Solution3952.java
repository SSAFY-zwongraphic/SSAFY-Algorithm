package swea.d_0902;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution3952 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("swea/d_0902/input3952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] student = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				student[i] = new ArrayList<>();
			}

			int[] order = new int[n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				student[s1].add(s2);
				order[s2]++;
			}

			Queue<Integer> queue = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();

			for (int i = 1; i <= n; i++) {
				if (order[i] == 0) {
					queue.offer(i);
					sb.append(i + " ");
				}
			}

			while (!queue.isEmpty()) {
				int current = queue.poll();

				for (int next : student[current]) {
					order[next]--;
					if (order[next] == 0) {
						queue.offer(next);
						sb.append(next + " ");
					}
				}
			}

			boolean result = true;
			for (int i = 1; i <= n; i++) {
				if (order[i] != 0) {
					result = false;
				}
			}

			if (result) {
				System.out.println("#" + t + " " + sb);
			}
		}
	}
}
