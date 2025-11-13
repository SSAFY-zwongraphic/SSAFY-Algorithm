package baekjoon.d_1112;

import java.util.Scanner;

public class Solution1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] result = new int[2];

		int n = 1;
		while (true) {
			int calc = n * (n + 1) / 2;
			if (calc >= x) {
				x -= (calc - n);
				break;
			}

			n++;
		}

		if (n % 2 != 0) {
			result[0] = n - (x - 1);
			result[1] = 1 + (x - 1);

		} else {
			result[0] = 1 + (x - 1);
			result[1] = n - (x - 1);

		}

		System.out.println(result[0] + "/" + result[1]);
		sc.close();
	}
}
