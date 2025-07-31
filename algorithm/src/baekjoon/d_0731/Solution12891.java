package baekjoon.d_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution12891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st1.nextToken());
		int P = Integer.parseInt(st1.nextToken());
		String dna = br.readLine();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int ACGT[] = new int[4];
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st2.nextToken());
		}
		int count = 0;

		int acgt[] = new int[4];
		String pwd = dna.substring(0, P);
		boolean b = true;
		for (int j = 0; j < P; j++) {
			switch (pwd.charAt(j)) {
			case 'A':
				acgt[0]++;
				break;
			case 'C':
				acgt[1]++;
				break;
			case 'G':
				acgt[2]++;
				break;
			case 'T':
				acgt[3]++;
				break;
			}
		}
		for (int j = 0; j < 4; j++) {
			if (acgt[j] < ACGT[j]) {
				b = false;
			}
		}
		if (b == true) {
			count++;
		}

		for (int i = 1; i < S - P + 1; i++) {
			b = true;
			switch (dna.charAt(i - 1)) {
			case 'A':
				acgt[0]--;
				break;
			case 'C':
				acgt[1]--;
				break;
			case 'G':
				acgt[2]--;
				break;
			case 'T':
				acgt[3]--;
				break;
			}
			switch (dna.charAt(i + P - 1)) {
			case 'A':
				acgt[0]++;
				break;
			case 'C':
				acgt[1]++;
				break;
			case 'G':
				acgt[2]++;
				break;
			case 'T':
				acgt[3]++;
				break;
			}
			for (int j = 0; j < 4; j++) {
				if (acgt[j] < ACGT[j]) {
					b = false;
				}
			}
			if (b == true) {
				count++;
			}
		}

		System.out.println(count);
	}
}
