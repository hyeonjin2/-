import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 파이프 옮기기1
public class Main {

	static int N, Ans;
	static int[][] map;
	// 파이프 이동 델타배열 우,하,우하
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0, 1, 0);
		System.out.println(Ans);
	}

	private static void dfs(int x1, int y1, int x2, int y2, int dir) {
		if (x2 == N - 1 && y2 == N - 1) {
			Ans++;
			return;
		}
		for (int d = 0; d < 3; d++) {
			// 현재 방향으로 이동이 가능하다면 이동
			// 진행방향이 가로일 때 세로 이동은 불가능
			if (dir == 0 && d == 1)
				continue;
			// 진행방향이 세로일 때 가로 이동은 불가능
			if (dir == 1 && d == 0)
				continue;
			if (check(x2, y2, d)) {
				int nx = x2 + dx[d];
				int ny = y2 + dy[d];
				dfs(x2, y2, nx, ny, d);
			}
		}
	}

	// 진행방향으로 이동 가능한지 검사
	private static boolean check(int x, int y, int d) {
		if (d == 0) {
			return (isIn(x, y + 1) && map[x][y + 1] == 0);

		} else if (d == 1) {
			return (isIn(x + 1, y) && map[x + 1][y] == 0);

		} else {
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!(isIn(nx, ny) && (map[nx][ny] == 0)))
					return false;
			}
			return true;
		}
	}

	// 배열 안의 범위인지 검사
	private static boolean isIn(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		else
			return true;
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}