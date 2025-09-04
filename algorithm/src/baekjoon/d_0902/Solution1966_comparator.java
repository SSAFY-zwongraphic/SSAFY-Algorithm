package baekjoon.d_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//이 풀이는 중요도가 같은 경우의 인쇄 순서를 제대로 수행하지 못해서 틀림
public class Solution1966_comparator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			List<int[]> docs = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int importance = Integer.parseInt(st.nextToken());
				docs.add(new int[] { i, importance });
			}

			Collections.sort(docs, new Comparator<int[]>() {
				@Override
				public int compare(int[] doc1, int[] doc2) {
					if (doc1[1] != doc2[1]) {
						return doc2[1] - doc1[1];
					} else {
						return doc1[0] - doc2[0];
					}
				}
			});

			int count = 0;
			for (int[] i : docs) {
				count++;
				if (i[0] == m) {
					break;
				}
			}

			System.out.println(count);
		}
	}
}
