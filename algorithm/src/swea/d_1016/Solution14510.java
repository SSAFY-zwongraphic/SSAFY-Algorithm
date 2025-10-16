package swea.d_1016;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14510 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/d_1016/input14510.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] tree = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			int maxTree = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				if (tree[i] > maxTree) {
					maxTree = tree[i];
				}
			}

			int twos = 0;
			int ones = 0;
			for (int i = 0; i < n; i++) {
				int gap = maxTree - tree[i];

				if (gap % 2 == 0) {
					twos += gap / 2;
				} else {
					ones++;
					gap -= 1;
					twos += gap / 2;
				}
			}

			int day = 0;
			while (true) {
				if (twos == 0 && ones == 0) {
					break;
				}

				day++;

				if (day % 2 == 1) {
					if (ones > 0) {
						ones--;
					} else {
						if (twos > 1) {
							twos--;
							ones++;
						}
					}
				} else {
					if (twos > 0) {
						twos--;
					}
				}
			}

			System.out.println("#" + t + " " + day);
		}
	}
}
