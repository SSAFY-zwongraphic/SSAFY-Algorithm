package baekjoon.d_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int[] ns = new int[n.length()];
		for (int i = 0; i < n.length(); i++) {
			ns[i] = Integer.parseInt(n.substring(i, i + 1));
		}

		for (int i = 0; i < ns.length; i++) {
			int max = 0;
			int index = 0;
			for (int j = ns.length- 1; j >= i; j--) {
				if (ns[j] >= max) {
					max = ns[j];
					index = j;
				}
			}
			if (index != i) {
				int temp = ns[i];
				ns[i] = ns[index];
				ns[index] = temp;
			}
		}
		
		for (int i : ns) {
			System.out.print(i);
		}
	}
}
