package baekjoon.d_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int Ns[] = new int[N + 1];
		for (int i = 0; i < N; i++) {
			Ns[i] = Integer.parseInt(st2.nextToken());
		}
		Ns[N] = 0;
		int count = 0;
		int start = 0;
		int end = 0;
		int sum = Ns[start];
		while (end < N) {
			if (sum == M) {
				count++;
				sum -= Ns[start];
				start++;
			} else if (sum > M) {
				sum -= Ns[start];
				start++;
			} else if (sum < M) {
				end++;
				sum += Ns[end];
			}
		}
		System.out.println(count);
	}
}

/*
다른 풀이
while (true) {
    if (sum >= M) {
        sum -= A[start++];
    } else if (end == N) {
        break;
    } else {
        sum += A[end++];
    }

    if (sum == M) count++;
}
*/