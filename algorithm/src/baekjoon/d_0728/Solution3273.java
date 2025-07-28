package baekjoon.d_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int A[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());

		int start = 0;
		int end = start + 1;
		int count = 0;
		while (start < n - 1) {
			if (A[start] + A[end] == x) {
				count++;
			}
			end++;
			if (end >= n) {
				start++;
				end = start + 1;
			}
		}
		System.out.println(count);
	}
}

//���� Ǭ ����� �ð����⵵�� O(N^2)
//������ ������������ �����ϰ� left=0, right=n-1�� Ǫ�°� �� ȿ����