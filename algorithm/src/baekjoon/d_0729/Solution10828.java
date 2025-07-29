package baekjoon.d_0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();

			switch (op) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
				break;
			case "pop":
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
					stack.pop();
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				boolean b = stack.isEmpty();
				if (b == true) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "top":
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				break;
			default:
				break;
			}
		}
	}
}
