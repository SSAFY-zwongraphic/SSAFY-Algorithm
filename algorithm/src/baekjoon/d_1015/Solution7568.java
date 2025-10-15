package baekjoon.d_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Human {
	public int height, weight, rank;

	public Human(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
}

//class SizeComparator implements Comparator<Human> {
//	@Override
//	public int compare(Human h1, Human h2) {
//		if (h1.height > h2.height && h1.weight > h2.weight)
//			return 1;
//		else if (h2.height > h1.height && h2.weight > h1.weight)
//			return -1;
//		else
//			return 0;
//	}
//}

public class Solution7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Human[] human = new Human[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			human[i] = new Human(height, weight);
		}

		for (int i = 0; i < n; i++) {
			int count = 0;

			for (int j = 0; j < n; j++) {
				int height = human[i].height;
				int weight = human[i].weight;

				if (height < human[j].height && weight < human[j].weight) {
					count++;
				}
			}

			human[i].rank = count + 1;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(human[i].rank + " ");
		}
	}
}
