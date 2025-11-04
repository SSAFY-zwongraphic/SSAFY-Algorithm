package baekjoon.d_1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1916 {
	public static int n, m;
	public static int[] dist;
	public static ArrayList<Bus>[] bus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		bus = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			bus[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			bus[start].add(new Bus(end, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int depart = Integer.parseInt(st.nextToken());
		int arrive = Integer.parseInt(st.nextToken());

		dijkstra(depart);

		System.out.println(dist[arrive]);
	}

	public static void dijkstra(int depart) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();

		dist[depart] = 0;
		pq.offer(new Bus(depart, 0));

		while (!pq.isEmpty()) {
			Bus current = pq.poll();
			int end = current.end;
			int cost = current.cost;

			if (dist[end] < cost) {
				continue;
			}

			for (Bus next : bus[end]) {
				int newCost = dist[end] + next.cost;
				if (newCost < dist[next.end]) {
					dist[next.end] = newCost;
					pq.offer(new Bus(next.end, newCost));
				}
			}
		}
	}
}

class Bus implements Comparable<Bus> {
	int end, cost;

	public Bus(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus b) {
		return this.cost - b.cost;
	}
}
