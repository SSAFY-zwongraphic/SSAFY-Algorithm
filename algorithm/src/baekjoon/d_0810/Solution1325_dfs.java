package baekjoon.d_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1325_dfs {

	public static ArrayList<Integer>[] graph;
	public static boolean[] hacked;
	public static int count;
	public static int[] counts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		hacked = new boolean[n + 1];
		counts = new int[n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			graph[c2].add(c1);
		}

		int max = 0;
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(hacked, false);
			count = 0;
			dfs(i);
			counts[i] = count;
			max = Math.max(max, count);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			if (counts[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	public static void dfs(int i) {
		hacked[i] = true;
		count++;
		for (int j : graph[i]) {
			if (!hacked[j]) {
				dfs(j);
			}
		}
	}
}