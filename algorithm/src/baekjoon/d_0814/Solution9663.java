package baekjoon.d_0814;

import java.util.Scanner;

public class Solution9663 {
	private static int[][] nn;
	private static boolean[][] possible;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nn = new int[n][n];
		possible = new boolean[n][n];

		for (int i = 0; i < nn.length; i++) {
			backtracking(i, 0);
		}
	}

	private static void backtracking(int col, int row) {
		for (int i = 0; i < nn.length; i++) {
			
		}
	}
}
