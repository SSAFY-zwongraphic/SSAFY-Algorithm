package swea.d_0821;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238 {
	private static ArrayList<Integer>[] network;
	private static boolean[] visited;
	private static int[] count;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/d_0821/input1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			network = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				network[i] = new ArrayList<>();
			}
			visited = new boolean[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				network[from].add(to);
			}
			count = new int[101];

			bfs(start);

			int max = 0;
			int result = 0;
			for (int i = 1; i <= 100; i++) {
				if (count[i] >= max) {
					max = count[i];
					result = i;
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}

	private static void bfs(int start) {
		//원래는 큐에 Integer배열(start, width)을 넣었으나 그럴 필요 없었음
		Queue<Integer> queue = new ArrayDeque<>();
		int width = 1;

		visited[start] = true;
		queue.offer(start);
		count[start] = width;

		while (!queue.isEmpty()) {
			start = queue.poll();

			for (int next : network[start]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
					count[next] = count[start] + 1;
				}
			}
		}
	}

}

//private static void bfs(int start, int width) {
//	Queue<Integer[]> queue = new ArrayDeque<>();
//
//	visited[start] = true;
//	queue.offer(new Integer[] { start, width });
//	count[start] = width;
//
//	while (!queue.isEmpty()) {
//		Integer[] arr = queue.poll();
//		start = arr[0];
//		width = arr[1];
//		width++;
//
//		for (int next : network[start]) {
//			if (!visited[next]) {
//				visited[next] = true;
//				queue.offer(new Integer[] { next, width });
//				count[next] = width;
//			}
//		}
//	
//	}
//}
