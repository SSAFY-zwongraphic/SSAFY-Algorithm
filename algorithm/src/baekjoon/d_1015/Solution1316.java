package baekjoon.d_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < n; i++) {
			boolean group = true;

			String s = br.readLine();
			boolean[] alphabet = new boolean[26];

			for (int j = 0; j < s.length(); j++) {
				char c1 = s.charAt(j);

				if (j > 0) {
					char c2 = s.charAt(j - 1);
					if (c1 == c2) {
						continue;
					}
				}

				if (!alphabet[c1 - 'a']) {
					alphabet[c1 - 'a'] = true;
				} else {
					group = false;
					break;
				}
			}

			if (group) {
				count++;
			}
		}

		System.out.println(count);
	}
}
