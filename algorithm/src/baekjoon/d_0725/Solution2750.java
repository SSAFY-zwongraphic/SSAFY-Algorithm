package baekjoon.d_0725;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] Ns = new int[N];
		for (int i = 0; i < N; i++) {
			Ns[i] = sc.nextInt();
		}
		Arrays.sort(Ns);
		for (int i : Ns) {
			System.out.println(i);
		}
	}
}
