package baekjoon.d_0904;

//사이클 생기는지 확인하는 문제  
public class Union_Find {
	public static int[] parent;

	public static int findParent(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findParent(parent[x]);
	}

	public static void unionParent(int a, int b) {
		int rootA = findParent(a);
		int rootB = findParent(b);

		if (rootA < rootB) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 } };

		parent = new int[n + 1];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}

		boolean hasCycle = false;
		int count = 0;
		for (int[] edge : edges) {
			int a = edge[0];
			int b = edge[1];
			count++;

			if (findParent(a) != findParent(b)) {
				unionParent(a, b);
			} else {
				hasCycle = true;
				break;
			}
		}

		System.out.println(count + "번째에서 사이클 발생!");
	}
}