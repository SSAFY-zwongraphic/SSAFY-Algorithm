package swea.d_0717;
import java.util.Scanner;

public class Solution1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N;
			int M;
			N = sc.nextInt();
			M = sc.nextInt();

			int[] A = new int[N];
			int[] B = new int[M];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}

			int max = Integer.MIN_VALUE;
			if (N <= M) {
				for (int i = 0; i < M - N + 1; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[i + j];
					}
					if (sum > max) {
						max = sum;
					}
				}
			} else {
				for (int i = 0; i < N - M + 1; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += B[j] * A[i + j];
					}
					if (sum > max) {
						max = sum;
					}
				}
			}

			System.out.printf("#%d %d\n", t, max);
		}
	}
}
