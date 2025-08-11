package baekjoon.d_0811;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (queue.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				int tmp = queue.poll();
				queue.offer(tmp);
			}
			int out = queue.poll();
			sb.append(out).append(", ");
		}

		sb.append(queue.poll());
		System.out.println("<" + sb + ">");
	}
}
