package baekjoon.d_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int X = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int come[] = new int[N];
		for (int i = 0; i < N; i++) {
			come[i] = Integer.parseInt(st2.nextToken());
		}
		int sum[] = new int[N - X + 1];
		int max = 0;
		int count = 0;
		for (int i = 0; i < X; i++) {
			sum[0] += come[i];
		}
		max = sum[0];
		for (int i = 1; i < N - X + 1; i++) {
			sum[i] = sum[i - 1] - come[i - 1] + come[i + X - 1];
			max = Math.max(max, sum[i]);
		}
		for (int i = 0; i < sum.length; i++) {
			if (sum[i] == max) {
				count++;
			}
		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}
	}
}
