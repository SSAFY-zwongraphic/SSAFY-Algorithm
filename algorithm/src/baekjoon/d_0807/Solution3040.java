package baekjoon.d_0807;

import java.util.Scanner;

public class Solution3040 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nine[] = new int[9];
		int sum = 0;
		int n1 = 0;
		int n2 = 0;
		for (int i = 0; i < 9; i++) {
			nine[i] = sc.nextInt();
			sum += nine[i];
		}

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				sum -= (nine[i] + nine[j]);
				if (sum == 100) {
					n1 = i;
					n2 = j;
					break;
				}
				sum += (nine[i] + nine[j]);
			}
		}

		for (int i = 0; i < 9; i++) {
			if (!(i == n1 || i == n2)) {
				System.out.println(nine[i]);
			}
		}
	}
}
