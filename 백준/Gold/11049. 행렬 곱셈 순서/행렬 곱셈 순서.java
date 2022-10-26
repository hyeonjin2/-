import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 행렬 곱셈 순서
public class Main {

	static int N;
	static long[][] d;
	static int[][] matrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}

		d = new long[N][N]; // d[i][j]:i번째 행렬과 j번째 행렬을 곱할 때의 곱셈 연산의 횟수의 최솟값
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					d[i][j] = 0;
				else
					d[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int k = 1; k < N; k++) {
			for (int i = 0; i + k < N; i++) {
				calc(i, i + k);
			}
		}
		System.out.println(d[0][N - 1]);
	}

	private static void calc(int start, int end) {
		for (int i = start; i < end; i++) {
			long temp = (long) d[start][i] + d[i + 1][end] + (long) matrix[start][0] * matrix[i][1] * matrix[end][1];
			d[start][end] = Math.min(d[start][end], temp);
		}
	}

}