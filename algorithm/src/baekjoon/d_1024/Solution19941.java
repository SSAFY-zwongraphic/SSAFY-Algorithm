package baekjoon.d_1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution19941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		char[] c = new char[n];
		int num = 0;

		for (int i = 0; i < n; i++) {
			c[i] = str.charAt(i);
		}

		for (int i = 0; i < n; i++) {
			if (c[i] == 'P') {
				for (int j = i - k; j <= i + k; j++) {
					if (j >= 0 && j < n && c[j] == 'H') {
						num++;
						c[j] = 'N';
						break;
					}
				}
			}
		}
		
		System.out.println(num);
	}
}
