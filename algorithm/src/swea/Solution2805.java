package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = tmp.charAt(j) - '0';
				}
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (i <= N / 2) {
					sum += farm[i][N / 2];
					for (int j = 0; j < i; j++) {
						sum += farm[i][N / 2 + (j + 1)];
						sum += farm[i][N / 2 - (j + 1)];
					}
				} else {
					sum += farm[i][N / 2];
					for (int j = 0; j < N - i -1 ; j++) {
						sum += farm[i][N / 2 + (j + 1)];
						sum += farm[i][N / 2 - (j + 1)];
					}
				}
			}

			System.out.printf("#%d %d\n", t, sum);
		}
	}
}
