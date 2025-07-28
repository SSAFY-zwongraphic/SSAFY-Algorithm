package baekjoon.d_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int temp[] = new int[N];
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st2.nextToken());
		}

		int start = 0;
		int end = start + K - 1;
		int sum = 0;
		for (int i = 0; i < start + K; i++) {
			sum += temp[i];
		}
		int max = sum;

		while (true) {
			start++;
			end++;
			if (end == N) {
				break;
			} else {
				sum = sum - temp[start - 1] + temp[end];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
