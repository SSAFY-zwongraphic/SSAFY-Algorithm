package baekjoon.d_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int NN[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				NN[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int left = 0;
		int right = n - 1;
		int count = 0;
		int max = Integer.MIN_VALUE;
		while (count < n) {
			if (left == right) {
				count++;
				max = NN[n - 1][right];
				for (int i = n - 1; i > 0; i--) {
					NN[i][right] = NN[i - 1][right];
				}
				NN[0][right] = Integer.MIN_VALUE;
				left = 0;
				right = n - 1;
			} else if (NN[n - 1][left] >= NN[n - 1][right]) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(max);
	}
}

//투포인터 공부중이라 최대한 투포인터로 풀었는데, 다음에 다른 방법으로도 풀어봐야지