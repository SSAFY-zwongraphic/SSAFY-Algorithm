package baekjoon.d_1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11256 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int candy = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());

			int boxes[] = new int[box];

			for (int b = 0; b < box; b++) {
				st = new StringTokenizer(br.readLine());
				int sero = Integer.parseInt(st.nextToken());
				int garo = Integer.parseInt(st.nextToken());

				boxes[b] = sero * garo;
			}

			Arrays.sort(boxes);

			int result = 0;
			for (int b = boxes.length - 1; b >= 0; b--) {
				if (candy > boxes[b]) {
					result++;
					candy -= boxes[b];
				} else {
					result++;
					break;
				}
			}
			
			System.out.println(result);
		}
	}
}
