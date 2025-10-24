package baekjoon.d_1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int rope[] = new int[n];

		for (int i = 0; i < n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < rope.length; i++) {
			rope[i] *= n;			
			max = Math.max(max, rope[i]);
			n--;
		}
		
		System.out.println(max);
	}
}
