package baekjoon.d_0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		int[] Ns = new int[N];
		int count = 0;
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Ns[i] = Integer.parseInt(st2.nextToken());
		}

		long[] S = new long[N];
		S[0] = Ns[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + Ns[i];
		}

		int[] Rs = new int[M];
		for (int i = 0; i < N; i++) {
			int R = (int) (S[i] % M);
			if (R == 0) {
				count++;
			}
			Rs[R]++;
		}

		for (int i = 0; i < M; i++) {
			if (Rs[i] > 1) {
				count += Rs[i] * (Rs[i] - 1) / 2;
			}
		}

		System.out.println(count);
	}
}
