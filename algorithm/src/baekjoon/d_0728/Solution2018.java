package baekjoon.d_0728;

import java.util.Scanner;

public class Solution2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1;
		int start = 1;
		int end = 1;
		int sum = 1;
		while (start != N) {
			if (sum == N) {
				count++;
				sum -= start;
				start++;
			} else if (sum > N) {
				sum -= start;
				start++;
			} else if (sum < N) {
				end++;
				sum += end;
			}
		}
		System.out.println(count);
	}
}
