package baekjoon.d_1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int setNum = n / 6;
		int pieceNum = n % 6;

		int[] setMoney = new int[m];
		int[] pieceMoney = new int[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int set = Integer.parseInt(st.nextToken());
			int piece = Integer.parseInt(st.nextToken());

			if (set > piece * 6) {
				set = piece * 6;
			}

			setMoney[i] = set;
			pieceMoney[i] = piece;
		}

		Arrays.sort(setMoney);
		Arrays.sort(pieceMoney);

		if (setMoney[0] < pieceMoney[0] * pieceNum) {
			System.out.println((setNum + 1) * setMoney[0]);
		} else {
			System.out.println(setNum * setMoney[0] + pieceNum * pieceMoney[0]);
		}
	}
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1049_Fixed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] setMoney = new int[m];
        int[] pieceMoney = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            setMoney[i] = Integer.parseInt(st.nextToken());
            pieceMoney[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(setMoney);
        Arrays.sort(pieceMoney);

        int minSet = setMoney[0];
        int minPiece = pieceMoney[0];

        int cost1 = n * minPiece;
        int cost2 = (n % 6 == 0) ? (n / 6) * minSet : (n / 6 + 1) * minSet;
        int cost3 = (n / 6) * minSet + (n % 6) * minPiece;

        int answer = Math.min(cost1, Math.min(cost2, cost3));
        
        System.out.println(answer);
    }
}
*/
