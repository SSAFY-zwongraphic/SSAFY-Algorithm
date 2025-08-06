package baekjoon.d_0806;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2023 {
	public static ArrayList<Integer>[] graph;
	public static ArrayList<Integer> prime = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		graph = new ArrayList[10];
		for (int i = 1; i < 10; i++) {
			if (i % 2 != 0 || i == 2) {
				graph[i] = new ArrayList<>();
				graph[i].add(1);
				graph[i].add(3);
				graph[i].add(5);
				graph[i].add(7);
				graph[i].add(9);
			}
		}

		int firstNum[] = { 2, 3, 5, 7 };
		for (int i : firstNum) {
			DFS(i, 1, n);
		}

		for (int i : prime) {
			System.out.println(i);
		}
	}

	public static void DFS(int i, int depth, int n) {
		if (depth == n) {
			prime.add(i);
			return;
		}

		if (depth < n) {
			for (int j : graph[i % 10]) {
				if (isPrime(i*10+j)) {
					DFS(i * 10 + j, depth + 1, n);
				}
			}
		}
	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
