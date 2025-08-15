package baekjoon.d_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		long A[] = new long[N + 1];
		long B[] = new long[M + 1];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st2.nextToken());
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st3.nextToken());
		}
		A[N] = Long.MAX_VALUE;
		B[M] = Long.MAX_VALUE;

		int a = 0;
		int b = 0;
		StringBuilder sb = new StringBuilder();
		while (a < N || b < M) {
			if (A[a] <= B[b]) {
				sb.append(A[a]).append(" ");
				a++;
			} else {
				sb.append(B[b]).append(" ");
				b++;
			}
		}
		System.out.println(sb);
	}
}

/*
 * 다른 풀이로는 while 조건문을 아래처럼 하고, while (a < N && b < M) 남은 요소 처리하는 코드 추가하는 방법이 있음
 * while (a < N) sb.append(A[a++]).append(" "); while (b < M)
 * sb.append(B[b++]).append(" ");
 */