package swea.d_0717;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int NN[][] = new int[N][N];
			int matrix90[][] = new int[N][N];
			int matrix180[][] = new int[N][N];
			int matrix270[][] = new int[N][N];
			for (int i = 0; i < NN.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < NN[i].length; j++) {
					NN[i][j] = Integer.parseInt(st.nextToken());
					matrix90[i][j] = 0;
					matrix180[i][j] = 0;
					matrix270[i][j] = 0;
				}
			}

			Solution1961 sol = new Solution1961();
			matrix90 = sol.rotate90(NN, matrix90);
			matrix180 = sol.rotate90(matrix90, matrix180);
			matrix270 = sol.rotate90(matrix180, matrix270);
			
			
		}
	}

	public int[][] rotate90(int[][] NN, int[][] MM) {
		for (int i = 0; i < NN.length; i++) {
			for (int j = 0; j < NN[i].length; j++) {
				MM[j][NN.length - i - 1] = NN[i][j];
			}
		}
		return MM;
	}
}
