package baekjoon.d_1128;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution25418 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int k = sc.nextInt();

		boolean[] visited = new boolean[k + 1];

		int result = bfs(a, k, visited);

		System.out.println(result);
	}

	public static int bfs(int a, int k, boolean[] visited) {
		Queue<int[]> queue = new ArrayDeque<>();

		visited[a] = true;
		queue.offer(new int[] { a, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentA = current[0];
			int currentCount = current[1];

			if (currentA == k) {
				return currentCount;
			}

			if ((currentA + 1) <= k && !visited[currentA + 1]) {
				visited[currentA + 1] = true;
				queue.offer(new int[] { currentA + 1, currentCount + 1 });
			}

			if ((currentA * 2) <= k && !visited[currentA * 2]) {
				visited[currentA * 2] = true;
				queue.offer(new int[] { currentA * 2, currentCount + 1 });
			}
		}

		return 0;
	}
}
