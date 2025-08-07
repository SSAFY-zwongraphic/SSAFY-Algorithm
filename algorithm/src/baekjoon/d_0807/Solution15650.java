package baekjoon.d_0807;

import java.util.ArrayList;
import java.util.Scanner;

//조합 실버 3
public class Solution15650 {
	public static int n;
	public static int m;
	public static boolean[] visited;
	public static ArrayList<Integer> result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n + 1];
		result = new ArrayList<>();
		result.add(0);

		Combination(0);
	}

	public static void Combination(int depth) {
		if (depth == m) {
			for (int i : result) {
				if (i != 0) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}

		if (depth < m) {
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && i > result.get(result.size() - 1)) {
					result.add(i);
					visited[i] = true;
					Combination(depth + 1);
					result.remove(result.size() - 1);
					visited[i] = false;
				}
			}
		}

	}
}
