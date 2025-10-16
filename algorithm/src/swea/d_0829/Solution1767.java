package swea.d_0829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1767 {
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n;
	private static int[][] cell;
	private static ArrayList<int[]> core;
	private static int maxCore;
	private static int minLine;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/d_0829/input1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			cell = new int[n][n];
			core = new ArrayList<>();
			maxCore = 0;
			minLine = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if (cell[i][j] == 1) {
						if (i > 0 && i < n - 1 && j > 0 && j < n - 1) {
							core.add(new int[] { i, j });
						}
					}
				}
			}

			setLine(0, 0, 0);

			if (maxCore == 0) {
				minLine = 0;
			}

			System.out.println("#" + t + " " + minLine);
		}
	}

	private static void setLine(int index, int coreNum, int lineNum) {
		if (index == core.size()) {
			if (coreNum > maxCore) {
				maxCore = coreNum;
				minLine = lineNum;
			} else if (coreNum == maxCore) {
				minLine = Math.min(minLine, lineNum);
			}
			return;
		}

		setLine(index + 1, coreNum, lineNum);

		int x = core.get(index)[0];
		int y = core.get(index)[1];

		for (int i = 0; i < 4; i++) {
			boolean possible = true;
			int currentLine = 0;

			int nx = x + dx[i];
			int ny = y + dy[i];

			while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (cell[nx][ny] == 1 || cell[nx][ny] == 2) {
					possible = false;
					break;
				}

				nx += dx[i];
				ny += dy[i];
			}

			if (possible) {
				nx = x + dx[i];
				ny = y + dy[i];

				while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					cell[nx][ny] = 2;
					currentLine++;
					nx += dx[i];
					ny += dy[i];
				}

				setLine(index + 1, coreNum + 1, lineNum + currentLine);

				nx = x + dx[i];
				ny = y + dy[i];
				while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					cell[nx][ny] = 0;
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
	}
}
