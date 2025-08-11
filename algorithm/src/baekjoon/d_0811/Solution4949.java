package baekjoon.d_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();

		while (true) {
			boolean isBalanced = true;
			stack.clear();
			String s = br.readLine();
			char tmp;

			if (s.equals(".")) {
				break;
			}

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch (c) {
				case '(':
					stack.push('(');
					break;
				case '[':
					stack.push('[');
					break;
				case ')':
					//pop하기 전에 stack이 비었는지 확인 먼저 할 것
					if (!stack.isEmpty()) {
						tmp = stack.pop();
						if (tmp != '(') {
							isBalanced = false;
						}
					} else {
						isBalanced = false;
					}
					break;
				case ']':
					if (!stack.isEmpty()) {
						tmp = stack.pop();
						if (tmp != '[') {
							isBalanced = false;
						}
					} else {
						isBalanced = false;
					}
					break;
				default:
					break;
				}

				if (!isBalanced) {
					break;
				}
			}

			//stack에 남은 게 있으면 yes가 아닌데 놓칠 뻔
			if (isBalanced && stack.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}

		System.out.print(sb);
	}
}
