package baekjoon.d_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			//index가 자꾸 바뀌므로 처음의 index도 포함 (HashMap은 무거워서 배열로)
			Queue<int[]> queue = new ArrayDeque<>();
			int[] importance = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				queue.offer(new int[] { i, tmp });
				importance[tmp]++;
			}

			int count = 0;
			while (true) {
				//중요도가 가장 큰 지 판단하는 boolean
				boolean max = true;
				int[] tmp = queue.poll();
				int index = tmp[0];
				int impor = tmp[1];

				for (int i = importance.length - 1; i > impor; i--) {
					if (importance[i] > 0) {
						max = false;
						break;
					}
				}

				if (max) {
					//완전히 뺄 때 importance개수 줄이는 거랑 count 더하는 거!
					importance[impor]--;
					count++;
					if (index == m) {
						break;
					}
				} else {
					queue.offer(tmp);
				}
			}

			System.out.println(count);
		}
	}
}
