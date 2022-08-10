import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			count = new int[M + 1][N + 1];
			System.out.println(comb(M, N));
		}
	}

	// mCn을 구하는 함수
	private static int comb(int m, int n) {
		if (m == n || n == 0) {
			count[m][n] = 1;
			return count[m][n];
		}
		if (count[m][n] == 0) {
			count[m][n] = comb(m - 1, n) + comb(m - 1, n - 1);
		}
		return count[m][n]; // mCn = m-1Cn + m-1Cn-1
	}
}