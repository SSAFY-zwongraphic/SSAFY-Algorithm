package baekjoon.d_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean b = true;
			if (num == 1) {
				b = false;
			}
			for (int j = 2; j < num; j++) {
				if (num % j == 0) {
					b = false;
				}
			}
			if (b == true) {
				count++;
			}
		}
		System.out.println(count);
	}
}
