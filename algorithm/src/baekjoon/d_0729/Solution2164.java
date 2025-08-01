package baekjoon.d_0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		for (int i = 0; i < N - 1; i++) {
			queue.poll();
			int x = queue.peek();
			queue.poll();
			queue.offer(x);
		}
		System.out.println(queue.poll());
	}
}
