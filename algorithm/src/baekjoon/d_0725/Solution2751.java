package baekjoon.d_0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] Ns = new int[N];
		for (int i = 0; i < N; i++) {
			Ns[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(Ns);
		StringBuilder sb = new StringBuilder();
		for (int i : Ns) {
			sb.append(i).append("\n");
		}
		System.out.print(sb);
	}
}
