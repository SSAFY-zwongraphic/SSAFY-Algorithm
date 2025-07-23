package swea.d_0717;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String memory = br.readLine();
			int[] m = new int[memory.length()];
			int[] z = new int[memory.length()];
			for (int i = 0; i < memory.length(); i++) {
				m[i] = memory.charAt(i) - '0';
				z[i] = 0;
			}

			int count = 0;
			for (int i = 0; i < m.length; i++) {
				if (z[i] != m[i]) {
					for (int j = i; j < z.length; j++) {
						z[j] = m[i];
					}
					count++;
				}
			}

			System.out.printf("#%d %d\n", t, count);
		}
	}
}
