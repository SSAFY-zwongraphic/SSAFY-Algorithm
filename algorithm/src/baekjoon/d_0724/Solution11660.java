package baekjoon.d_0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2차원 배열 구간합
public class Solution11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		int Ns[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				Ns[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		int S[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + Ns[i][j];
			}
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st3.nextToken());
			int y1 = Integer.parseInt(st3.nextToken());
			int x2 = Integer.parseInt(st3.nextToken());
			int y2 = Integer.parseInt(st3.nextToken());

			System.out.println(S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1]);
		}
	}
}
