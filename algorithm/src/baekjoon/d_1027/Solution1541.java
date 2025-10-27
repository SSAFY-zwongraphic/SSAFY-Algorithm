package baekjoon.d_1027;

import java.util.Scanner;

public class Solution1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String expression = sc.next();
		StringBuilder sb = new StringBuilder();
		int plus = 0;
		int minus = 0;

		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);

			switch (c) {
			case '+':
				plus += Integer.parseInt(sb.reverse().toString());
				sb.setLength(0);
				break;
			case '-':
				minus += Integer.parseInt(sb.reverse().toString());
				minus += plus;
				plus = 0;
				sb.setLength(0);
				break;
			default:
				sb.append(c);
				break;
			}
		}

		plus += Integer.parseInt(sb.reverse().toString());
		System.out.println(plus - minus);
	}
}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusSplit = br.readLine().split("\\-");
        
        int result = 0; 

        String[] plus = minusSplit[0].split("\\+");
        for (String s : plus) {
            result += Integer.parseInt(s);
        }

        for (int i = 1; i < minusSplit.length; i++) {
            int minusSum = 0;
            String[] minus = minusSplit[i].split("\\+");
            
            for (String s : minus) {
                minusSum += Integer.parseInt(s);
            }
            
            result -= minusSum;
        }
        
        System.out.println(result);
    }
}
 */
