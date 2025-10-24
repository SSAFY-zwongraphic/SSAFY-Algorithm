package baekjoon.d_1023;

import java.util.Scanner;

public class Solution1783 {
	static int n, m;

	static int[] move0 = { 1, -2 };
	static int[] move1 = { 2, -1 };
	static int[] move2 = { 2, 1 };
	static int[] move3 = { 1, 2 };

	static int startX = 0;
	static int startY = n - 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		int result = 1;

		boolean possible = (n >= 3) && (m >= 7);
		
		boolean n2m3 = (n == 2) && (m >= 3 && m < 5);
		boolean n2m5 = (n == 2) && (m >= 5 && m < 7);
		boolean n2m7 = (n == 2) && (m >= 7);
		
		boolean n3m2 = (n >= 3) && (m >= 2 && m < 3);
		boolean n3m3 = (n >= 3) && (m >= 3 && m < 4);
		boolean n3m4 = (n >= 3) && (m >= 4 && m < 7);

		if (possible) {
			m -= 7;
			result += 4 + m;
		} else if (n2m3) {
			result += 1;
		} else if (n2m5) {
			result += 2;
		} else if (n2m7) {
			result += 3;
		} else if (n3m2) {
			result += 1;
		} else if (n3m3) {
			result += 2;
		} else if (n3m4) {
			result += 3;
		}

		System.out.println(result);

		sc.close();
	}
}

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        if (n == 1) {
            result = 1;
            
        } else if (n == 2) {
            result = Math.min(4, (m + 1) / 2);
            
        } else {
            if (m < 7) {
                result = Math.min(4, m);
            } else {
                result = 5 + (m - 7); 
            }
        }

        System.out.println(result);
        sc.close();
    }
}
*/
