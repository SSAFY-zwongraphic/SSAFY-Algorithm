package baekjoon.d_0812;

import java.util.Arrays;
import java.util.Scanner;

public class Temp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		// step 0
		Arrays.sort(input);

		nextPermutation(input);
	}

	// 사전순으로 다음 순열 생성
	// 출력값 boolean인 이유: 배열은 객체라 값은 알아서 바뀌고 언제 마지막인지 판단해야 해서
	private static boolean nextPermutation(int[] input) {
		int n = input.length;
		// step 1
		int i = n - 1;
		while (i > 0 && input[i - 1] >= input[i]) {
			i--;

			if (i == 0) {
				return false;
			}
		}

		// step 2
		int j = n - 1;
		while (input[i - 1] >= input[j]) {
			j--;
		}

		// step 3
		int temp = input[i - 1];
		input[i - 1] = input[j];
		input[j] = temp;

		// step 4
		int k = n - 1;
		//마저 해야함

		return true;
	}
}
