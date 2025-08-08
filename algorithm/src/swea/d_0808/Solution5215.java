package swea.d_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5215 {
	public static int n;
	public static int maxCal;
	public static int[] taste;
	public static int[] cal;
	public static int sumTaste;
	public static int sumCal;
	public static int maxTaste;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			maxCal = Integer.parseInt(st.nextToken());
			taste = new int[n];
			cal = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			sumTaste = 0;
			sumCal = 0;
			maxTaste = 0;

			combination(0);

			System.out.printf("#%d %d\n", t, maxTaste);
		}
	}

	public static void combination(int num) {
		if (sumCal <= maxCal) {
			maxTaste = Math.max(maxTaste, sumTaste);
		}

		for (int i = num; i < n; i++) {
			sumTaste += taste[i];
			sumCal += cal[i];
			combination(i + 1);
			sumTaste -= taste[i];
			sumCal -= cal[i];
		}

	}
}
