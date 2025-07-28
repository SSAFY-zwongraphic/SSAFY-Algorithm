package baekjoon.d_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1940_Book {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int Ns[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Ns[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Ns);
		int count = 0;
		int start = 0;
		int end = N - 1;
		while (start < end) {
			if (Ns[start] + Ns[end] == M) {
				count++;
				start++;
				end--;
			} else if (Ns[start] + Ns[end] > M) {
				end--;
			} else if (Ns[start] + Ns[end] < M) {
				start++;
			}
		}
		System.out.println(count);
	}
}
