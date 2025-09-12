package baekjoon.d_0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11726 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long d[] = new long[1001];
		d[1] = 1;
		d[2] = 2;

		for (int i = 3; i <= n; i++) {
			d[i] = (d[i - 1] + d[i - 2]) % 10007;
		}

		System.out.println(d[n]);
	}
}
