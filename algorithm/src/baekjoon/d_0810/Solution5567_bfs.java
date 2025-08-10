package baekjoon.d_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5567_bfs {
	public static ArrayList<Integer>[] friend;
	public static boolean[] invited;
	public static int depth;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		friend = new ArrayList[n + 1];
		invited = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			friend[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			friend[f1].add(f2);
			friend[f2].add(f1);
		}

		depth = 0;
		count = 0;
		bfs(1);

		System.out.println(count);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();

		invited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				start = queue.poll();

				for (int next : friend[start]) {
					if (!invited[next]) {
						invited[next] = true;
						queue.offer(next);
						count++;
					}
				}
			}

			depth++;
			if (depth >= 2) {
				break;
			}
		}
	}
}
