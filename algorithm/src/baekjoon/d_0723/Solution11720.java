package baekjoon.d_0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		int Ns[] = new int[N];
		int sum = 0;
		String tmp = br.readLine();
		for (int i = 0; i < N; i++) {
//			Ns[i] = tmp.charAt(i) - '0';
//			sum += Ns[i];
			sum += tmp.charAt(i) - '0';
		}

		System.out.println(sum);
	}
}
