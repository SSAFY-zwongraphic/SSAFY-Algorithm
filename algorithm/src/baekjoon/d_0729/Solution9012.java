package baekjoon.d_0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < T; i++) {
			boolean result = true;
			String PS = br.readLine();
			int index = 0;
			while (index < PS.length()) {
				char c = PS.charAt(index++);
				if (c == '(') {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						result = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (!stack.isEmpty()) {
				result = false;
			}
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			stack.clear();
		}
	}
}
