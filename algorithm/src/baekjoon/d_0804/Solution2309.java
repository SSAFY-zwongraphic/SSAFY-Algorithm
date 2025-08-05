package baekjoon.d_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nine = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			nine[i] = Integer.parseInt(br.readLine());
			sum += nine[i];
		}
		
		Arrays.sort(nine);

		int n1 = 0;
		int n2 = 0;
		for (int i = 0; i < 8; i++) {
			int subsum = 0;
			for (int j = i + 1; j < 9; j++) {
				subsum = sum - nine[i] - nine[j];
				if (subsum == 100) {
					n1 = i;
					n2 = j;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			if (i == n1 || i == n2) {
				continue;
			} else {
				System.out.println(nine[i]);
			}
		}
	}
}
