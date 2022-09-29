import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈주범 검거
public class Solution {

	static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N, M, totalTime, Ans;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			totalTime = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(x, y);

			sb.append("#").append(tc).append(" ").append(Ans).append("\n");
		}
		System.out.println(sb);
	}

	// 상하좌우, 상하, 좌우, 상우, 하우, 하좌, 상좌
	static int[][] dx = { {}, { -1, 1, 0, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
	static int[][] dy = { {}, { 0, 0, -1, 1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

	private static void bfs(int sx, int sy) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		queue.offer(new Point(sx, sy, 1));
		Ans++;
		visited[sx][sy] = true;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int time = cur.time;
			int dir = map[x][y];
			if (time == totalTime) {
				return;
			}
			for (int d = 0; d < dx[dir].length; d++) {
				int nx = x + dx[dir][d];
				int ny = y + dy[dir][d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny])
					continue;
				// 갈 수 있는지 체크
				boolean flag = false;
				int ndir = map[nx][ny];
				for (int dd = 0; dd < dx[ndir].length; dd++) {
					int bx = nx + dx[ndir][dd];
					int by = ny + dy[ndir][dd];
					if (bx == x && by == y) {
						flag = true;
					}
				}
				if (flag) {
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, time + 1));
					Ans++;
				}
			}
		}
	}
}
