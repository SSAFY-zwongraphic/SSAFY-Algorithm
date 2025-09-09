package baekjoon.d_0908;

import java.util.Scanner;

public class Solution2747_TopDown {
	private static int[] f;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;

		System.out.println(fibonacci(n));
		sc.close();
	}

	private static int fibonacci(int x) {
		if (x == 0) return 0;
		if (x == 1) return 1;
		
		if (f[x] != 0) {
			return f[x];
		}
		return f[x] = fibonacci(x - 1) + fibonacci(x - 2);
	}
}
