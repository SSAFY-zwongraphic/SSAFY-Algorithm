package baekjoon.d_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		int sum = 0;
		for (int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				sum -= stack.pop();
			} else {
				stack.push(n);
				sum += n;
			}
		}
		System.out.println(sum);
	}
}
