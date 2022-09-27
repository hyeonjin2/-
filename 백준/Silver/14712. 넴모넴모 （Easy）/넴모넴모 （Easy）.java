import java.util.Scanner;

// 넴모넴모(Easy)
public class Main {

	static int N, M;
	static int Ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		dfs(0);
		System.out.println(Ans);
	}

	private static void dfs(int cnt) {
		if (cnt == N * M) {
			Ans++;
			return;
		}
		int x = cnt / M + 1;
		int y = cnt % M + 1;

		if (map[x - 1][y] == 1 && map[x][y - 1] == 1 && map[x - 1][y - 1] == 1) {
			dfs(cnt + 1);
		} else {
			map[x][y] = 1;
			dfs(cnt + 1);
			map[x][y] = 0;
			dfs(cnt + 1);
		}
	}
}