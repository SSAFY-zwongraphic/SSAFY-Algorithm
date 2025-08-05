package baekjoon.d_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P[] = new int[N];
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			int target = P[i];
			for (int j = i - 1; j >= 0; j--) {
				if (target < P[j]) {
					P[j + 1] = P[j];
					P[j] = target;
				} else {
					break;
				}
			}
		}

		int S[] = new int[N];
		S[0] = P[0];
		int sum = S[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + P[i];
			sum += S[i];
		}

		System.out.println(sum);
	}
}
