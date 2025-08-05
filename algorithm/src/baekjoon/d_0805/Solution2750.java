package baekjoon.d_0805;

import java.util.Scanner;

// ÄüÁ¤·Ä ¿¬½À
public class Solution2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int N[] = new int[n];
		for (int i = 0; i < n; i++) {
			N[i] = sc.nextInt();
		}

		quickSort(N, 0, n - 1);

		for (int i : N) {
			System.out.println(i);
		}
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int pivot = partition(arr, left, right);

		quickSort(arr, left, pivot);
		quickSort(arr, pivot + 1, right);
	}

	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];

		while (left <= right) {
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left - 1;
	}

	public static void swap(int arr[], int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
