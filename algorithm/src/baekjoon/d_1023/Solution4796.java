package baekjoon.d_1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = 0;
		
		while (true) {
			c++;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (l == 0 && p == 0 && v == 0) {
				break;
			}

			int share = v / p;
			int rest = v % p;
			if (rest > l) {
				rest = l;
			}

			int possible = share * l + rest;

			System.out.println("Case " + c + ": " + possible);
		}
	}
}
