package swea.d_0821;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5643 {
	private static ArrayList<Integer>[] studentUp;
	private static ArrayList<Integer>[] studentDown;
	private static boolean[] known;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/d_0821/input5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			studentUp = new ArrayList[n + 1];
			studentDown = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				studentUp[i] = new ArrayList<>();
				studentDown[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				studentUp[s1].add(s2);
				studentDown[s2].add(s1);
			}

			known = new boolean[n + 1];
			int count = 0;
			for (int i = 1; i <= n; i++) {
				boolean knownAll = true;
				Arrays.fill(known, false);

				bfsUp(i);
				bfsDown(i);

				for (int j = 1; j <= n; j++) {
					if (!known[j]) {
						knownAll = false;
					}
				}

				if (knownAll) {
					count++;
				}
			}

			System.out.println("#" + t + " " + count);
		}
	}

	private static void bfsUp(int start) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(start);
		known[start] = true;

		while (!queue.isEmpty()) {
			start = queue.poll();

			for (int next : studentUp[start]) {
				if (!known[next]) {
					queue.offer(next);
					known[next] = true;
				}
			}
		}
	}

	private static void bfsDown(int start) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(start);
		known[start] = true;

		while (!queue.isEmpty()) {
			start = queue.poll();

			for (int next : studentDown[start]) {
				if (!known[next]) {
					queue.offer(next);
					known[next] = true;
				}
			}
		}
	}
}
