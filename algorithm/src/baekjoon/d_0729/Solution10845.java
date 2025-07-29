package baekjoon.d_0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch (op) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				queue.offer(x);
				break;
			case "pop":
				if (!queue.isEmpty()) {
					System.out.println(queue.peek());
					queue.poll();	
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if (!queue.isEmpty()) {
					System.out.println(queue.peek());	
				} else {
					System.out.println(-1);
				}
				break;
			case "back":
				if (!queue.isEmpty()) {
					System.out.println(queue.peekLast());	
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}
