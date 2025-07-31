package baekjoon.d_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution24499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int pie[] = new int[2 * N];
		for (int i = 0; i < N; i++) {
			pie[i] = Integer.parseInt(st2.nextToken());
			pie[i + N] = pie[i];
		}
		int sum = 0;
		int max = 0;
		if (K == 1) {
			for (int i = 0; i < N; i++) {
				max = Math.max(max, pie[i]);
			}
		} else if (K == N) {
			for (int i = 0; i < N; i++) {
				max += pie[i];
			}
		} else {
			for (int i = 0; i < K; i++) {
				sum += pie[i];
				max = sum;
			}
			//N - K + 1 + (K - 1) = N
			for (int i = 1; i < N; i++) {
				sum -= pie[i - 1];
				sum += pie[K + i - 1];
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
}
