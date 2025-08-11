package baekjoon.d_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		int bit = 0;
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int x;
			switch (op) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				bit |= 1 << x;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				bit &= ~(1 << x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				sb.append(((bit >> x) & 1) == 1 ? 1 : 0).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if (((bit >> x) & 1) == 1) {
					bit &= ~(1 << x);
				} else {
					bit |= 1 << x;
				}
				break;
			case "all":
				bit |= ~bit;
				break;
			case "empty":
				bit &= ~bit;
				break;
			}
		}
		
		System.out.println(sb);
	}
}
