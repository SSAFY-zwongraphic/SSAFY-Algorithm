package baekjoon.d_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int target[] = new int[N];
		for (int i = 0; i < N; i++) {
			target[i] = Integer.parseInt(br.readLine());
		}

		int num = 1;
		int index = 0;
		while (index < N) {
			if (num < target[index]) {
				stack.push(num);
				sb.append("+").append("\n");
				num++;
			} else if (num == target[index]) {
				stack.push(num);
				sb.append("+").append("\n");
				stack.pop();
				sb.append("-").append("\n");
				num++;
				index++;
			} else {
				if (stack.peek() == target[index]) {
					stack.pop();
					sb.append("-").append("\n");
					index++;
				} else {
					System.out.println("NO");
					sb.setLength(0);
					break;
				}
			}
		}

		System.out.println(sb);
	}
}
