package baekjoon.d_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int card[] = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st2.nextToken());
		}

		int sum = 0;
		int max = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					sum = card[i] + card[j] + card[k];
					
					if (sum == M) {
						System.out.println(sum);
						return;
					} else if (sum < M){
						max = Math.max(sum, max);
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
