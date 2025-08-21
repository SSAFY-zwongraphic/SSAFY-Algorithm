package swea.d_0821;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873 {
	private static int h, w;
	private static char[][] map;
	private static int x, y;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("swea/d_0821/input1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String component = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = component.charAt(j);

					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}

			int n = Integer.parseInt(br.readLine());
			String actions = br.readLine();
			for (int i = 0; i < n; i++) {
				char action = actions.charAt(i);

				switch (action) {
				case 'U':
					U();
					break;
				case 'D':
					D();
					break;
				case 'L':
					L();
					break;
				case 'R':
					R();
					break;
				case 'S':
					S(x, y, map[x][y]);
					break;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void U() {
		map[x][y] = '^';
		if (x > 0 && map[x - 1][y] == '.') {
			map[x - 1][y] = map[x][y];
			map[x][y] = '.';
			x = x - 1;
		}
	}

	private static void D() {
		map[x][y] = 'v';
		if (x < h - 1 && map[x + 1][y] == '.') {
			map[x + 1][y] = map[x][y];
			map[x][y] = '.';
			x = x + 1;
		}
	}

	private static void L() {
		map[x][y] = '<';
		if (y > 0 && map[x][y - 1] == '.') {
			map[x][y - 1] = map[x][y];
			map[x][y] = '.';
			y = y - 1;
		}
	}

	private static void R() {
		map[x][y] = '>';
		if (y < w - 1 && map[x][y + 1] == '.') {
			map[x][y + 1] = map[x][y];
			map[x][y] = '.';
			y = y + 1;
		}
	}

	private static void S(int dx, int dy, char direction) {
		while (true) {
			if (direction == '^')
				dx--;
			else if (direction == 'v')
				dx++;
			else if (direction == '<')
				dy--;
			else if (direction == '>')
				dy++;

			if (dx < 0 || dx >= h || dy < 0 || dy >= w)
				break;

			if (map[dx][dy] == '#')
				break;

			if (map[dx][dy] == '*') {
				map[dx][dy] = '.';
				break;
			}
		}
	}
}

//switch (direction) {
//case '^':
//	if (dx == 0) {
//		return;
//	}
//	if (map[dx - 1][dy] == '#') {
//		return;
//	} else if (map[dx - 1][dy] == '*') {
//		map[dx - 1][dy] = '.';
//		return;
//	} else {
//		S(dx - 1, dy, direction);
//	}
//	break;
//case 'v':
//	if (dx == h - 1) {
//		return;
//	}
//	if (map[dx + 1][dy] == '#') {
//		return;
//	} else if (map[dx + 1][dy] == '*') {
//		map[dx + 1][dy] = '.';
//		return;
//	} else {
//		S(dx + 1, dy, direction);
//	}
//	break;
//case '<':
//	if (dy == 0) {
//		return;
//	}
//	if (map[dx][dy - 1] == '#') {
//		return;
//	} else if (map[dx][dy - 1] == '*') {
//		map[dx][dy - 1] = '.';
//		return;
//	} else {
//		S(dx, dy - 1, direction);
//	}
//	break;
//case '>':
//	if (dy == w - 1) {
//		return;
//	}
//	if (map[dx][dy + 1] == '#') {
//		return;
//	} else if (map[dx][dy + 1] == '*') {
//		map[dx][dy + 1] = '.';
//		return;
//	} else {
//		S(dx, dy + 1, direction);
//	}
//	break;
//}
