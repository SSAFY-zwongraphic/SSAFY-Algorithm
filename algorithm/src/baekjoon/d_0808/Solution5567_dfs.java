package baekjoon.d_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution5567_dfs {
	public static ArrayList<Integer>[] friend;
	public static int depth;
	public static boolean[] invited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		friend = new ArrayList[n + 1];
		depth = 0;
		invited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			friend[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			friend[f1].add(f2);
			friend[f2].add(f1);
		}
		dfs(1, 0);
		int count = 0;
		for (int i = 2; i < n + 1; i++) {
			if (invited[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void dfs(int num, int depth) {
		if (depth == 2) {
			return;
		}

		if (depth < 2) {
			for (int i : friend[num]) {
				invited[i] = true;
				dfs(i, depth + 1);

			}
		}
	}
}

/* BFS 방식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] friend = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friend[f1].add(f2);
            friend[f2].add(f1);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] invited = new boolean[n + 1];
        int count = 0;

        // 시작점: 상언(1번), 깊이(0)
        q.add(new int[]{1, 0});
        invited[1] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int person = current[0];
            int depth = current[1];

            // 친구의 친구까지만(depth=2) 탐색하고, 그 이상은 초대하지 않음
            if (depth >= 2) {
                continue;
            }

            for (int nextFriend : friend[person]) {
                if (!invited[nextFriend]) {
                    invited[nextFriend] = true;
                    count++;
                    q.add(new int[]{nextFriend, depth + 1});
                }
            }
        }
        System.out.println(count);
    }
}
 */

/* 이중반복문
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] friend = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friend[f1].add(f2);
            friend[f2].add(f1);
        }

        boolean[] invited = new boolean[n + 1];
        invited[1] = true; // 상언은 초대 대상에서 제외

        // 1. 상언의 직접 친구들을 초대 명단에 올림
        for (int f1 : friend[1]) {
            invited[f1] = true;
        }

        // 2. 상언의 직접 친구들의 친구들을 초대 명단에 올림
        for (int f1 : friend[1]) {
            for (int f2 : friend[f1]) {
                invited[f2] = true;
            }
        }

        // 3. 초대된 사람 수 계산 (상언 제외)
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (invited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
 */
