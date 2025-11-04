package baekjoon.d_1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1753 {
	public static ArrayList<Node>[] list;
	public static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		list = new ArrayList[v + 1];
		result = new int[v + 1];
		Arrays.fill(result, Integer.MAX_VALUE);

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		int e = Integer.parseInt(st.nextToken());

		int depart = Integer.parseInt(br.readLine());

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, value));
		}

		dijkstra(depart);

		for (int i = 1; i <= v; i++) {
			if (result[i] < Integer.MAX_VALUE) {
				System.out.println(result[i]);
			} else {
				System.out.println("INF");
			}
		}

	}

	public static void dijkstra(int depart) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		result[depart] = 0;
		pq.offer(new Node(depart, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int end = node.end;
			int value = node.value;

			if (result[end] < value) {
				continue;
			}

			for (Node next : list[end]) {
				if (result[end] + next.value < result[next.end]) {
					result[next.end] = result[end] + next.value;
					pq.offer(new Node(next.end, result[next.end]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int end, value;

	public Node(int end, int value) {
		this.end = end;
		this.value = value;
	}

	@Override
	public int compareTo(Node n) {
		return this.value - n.value;
	}
}
