package swea.d_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//D3
public class Solution6808 {
	public static int[] gyu;
	public static int[] in;
	public static boolean[] visited = new boolean[9];
	public static ArrayList<Integer> in2 = new ArrayList<>();
	public static int winGyu = 0;
	public static int loseGyu = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyu = new int[9];
			in = new int[9];
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
			}
			int index = 0;
			for (int i = 1; i <= 18; i++) {

				boolean isGyu = false;
				for (int j = 0; j < 9; j++) {
					if (i == gyu[j]) {
						isGyu = true;
						break;
					}
				}
				if (!isGyu) {
					in[index++] = i;
				}
			}

			Permutation(0);

			System.out.printf("#%d %d %d\n", t, winGyu, loseGyu);
			winGyu = 0;
			loseGyu = 0;
		}
	}

	public static void Permutation(int depth) {
		if (depth == 9) {
			Game(in2);
			return;
		}

		if (depth < 9) {
			for (int i = 0; i < 9; i++) {
				if (!visited[i]) {
					in2.add(in[i]);
					visited[i] = true;
					Permutation(depth + 1);
					in2.remove(in2.size() - 1);
					visited[i] = false;
				}
			}
		}
	}

	public static void Game(ArrayList<Integer> in) {
		int gyuScore = 0;
		int inScore = 0;
		for (int i = 0; i < 9; i++) {
			if (gyu[i] > in.get(i)) {
				gyuScore += gyu[i] + in.get(i);
			} else if (gyu[i] < in.get(i)) {
				inScore += gyu[i] + in.get(i);
			}
		}
		if (gyuScore > inScore) {
			winGyu++;
		} else if (gyuScore < inScore) {
			loseGyu++;
		}
	}
}
