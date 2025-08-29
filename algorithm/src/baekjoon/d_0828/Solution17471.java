package baekjoon.d_0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17471 {
	private static int n;
	private static ArrayList<Integer>[] wholeArea;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] population = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		wholeArea = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			wholeArea[i] = new ArrayList<>();

			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int neighbor = Integer.parseInt(st.nextToken());
				wholeArea[i].add(neighbor);
			}
		}

		ArrayList<Integer> areaA = new ArrayList<>();
		ArrayList<Integer> areaB = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < (1 << (n - 1)); i++) {
			areaA.clear();
			areaB.clear();

			for (int j = 0; j < (n - 1); j++) {
				if ((i & (1 << j)) != 0) {
					areaA.add(j + 1);
				} else {
					areaB.add(j + 1);
				}
			}

			areaA.add(n);
			if (areaB.isEmpty()) {
				continue;
			}

			if (check(areaA) && check(areaB)) {
				int sumA = 0;
				int sumB = 0;

				for (int k : areaA) {
					sumA += population[k];
				}

				for (int k : areaB) {
					sumB += population[k];
				}

				if (Math.abs(sumA - sumB) < min) {
					min = Math.abs(sumA - sumB);
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static boolean check(ArrayList<Integer> area) {
		boolean[] visited = new boolean[n + 1];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(area.get(0));
		visited[area.get(0)] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i : wholeArea[current]) {
				if (area.contains(i) && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

		for (int i = 0; i < area.size(); i++) {
			if (!visited[area.get(i)]) {
				return false;
			}
		}

		return true;
	}
}
