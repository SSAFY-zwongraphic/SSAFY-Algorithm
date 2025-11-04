package baekjoon.d_1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		Load[] load = new Load[n];
		int[] dist = new int[d + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			load[i] = new Load(start, end, length);
		}

		dist[0] = 0;
		for (int i = 1; i < dist.length; i++) {
			dist[i] = dist[i - 1] + 1;

			for (int j = 0; j < n; j++) {
				if (load[j].end == i) {
					int start = load[j].start;
					int end = load[j].end;
					int length = load[j].length;

					if (end > d) {
						continue;
					}

					if (length >= end - start) {
						continue;
					}

					dist[i] = Math.min(dist[i], dist[start] + length);
				}
			}
		}

		System.out.println(dist[d]);
	}
}

class Load {
	int start, end, length;

	Load(int start, int end, int length) {
		this.start = start;
		this.end = end;
		this.length = length;
	}
}
