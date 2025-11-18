package baekjoon.d_1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int fruit = Integer.parseInt(br.readLine());

		int maxWidth = 0;
		int maxHeight = 0;

		Node[] nodeList = new Node[6];

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			nodeList[i] = new Node(n1, n2);

			if (n1 == 1 || n1 == 2) {
				maxWidth = Math.max(maxWidth, n2);
			}

			if (n1 == 3 || n1 == 4) {
				maxHeight = Math.max(maxHeight, n2);
			}
		}

		int minWidth = 0;
		int minHeight = 0;

		for (int i = 0; i < 6; i++) {
			boolean width = nodeList[i].direction == 1 || nodeList[i].direction == 2;
			boolean heigth = nodeList[i].direction == 3 || nodeList[i].direction == 4;

			if (width && nodeList[i].length == maxWidth) {
				minWidth = nodeList[(i + 3) % 6].length;
			}

			if (heigth && nodeList[i].length == maxHeight) {
				minHeight = nodeList[(i + 3) % 6].length;
			}
		}
		
		int result = (maxWidth * maxHeight - minWidth * minHeight) * fruit;

		System.out.println(result);
	}
}

class Node {
	int direction, length;

	public Node(int direction, int length) {
		super();
		this.direction = direction;
		this.length = length;
	}
}