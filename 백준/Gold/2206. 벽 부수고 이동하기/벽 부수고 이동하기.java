import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class Main {

	static class Point {
		int x, y;
		int d;
		boolean used;

		public Point(int x, int y, int d, boolean used) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.used = used;
		}
	}

	static int N, M, Ans;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
//		print(map);
		Ans = Integer.MAX_VALUE;
		bfs();
		if (Ans == Integer.MAX_VALUE) {
			Ans = -1;
		}
		System.out.println(Ans);
	}

	// 4방 탐색 델타 배열 상,하,좌,우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(0, 0, 1, false));
		visited = new boolean[2][N][M];
		visited[0][0][0] = true;
		visited[1][0][0] = true;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			boolean used = cur.used;
			// 벽을 부수지 않았을때 방문한 경우의 인덱스 [0][nx][ny];
			int index = 0;
			// 벽을 부셨을 때 방문한 경우의 인덱스 [1[nx][ny];
			if (used)
				index = 1;
			if (x == N - 1 && y == M - 1) {
				Ans = Math.min(Ans, cur.d);
			}
			if (cur.d >= Ans) {
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				// 배열의 범위를 벗어나거나 이미 방문한 곳이면 건너뜀
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[index][nx][ny])
					continue;
				// 이미 벽을 한번 부셨을 때 또 벽이 나타나면 건너뜀
				if (used && map[nx][ny] == 1) {
					continue;
				}
				// 벽을 안부셨는데 벽이 나타나면 부셔보기
				if (!used && map[nx][ny] == 1) {
					visited[1][nx][ny] = true;
					map[nx][ny] = 0;
					queue.add(new Point(nx, ny, cur.d + 1, true));
					map[nx][ny] = 1;
				}
				// 벽이 아니라면 탐색
				if (map[nx][ny] == 0) {
					visited[index][nx][ny] = true;
					queue.add(new Point(nx, ny, cur.d + 1, used));
				}
//				visited[nx][ny] = false;
			}
		}
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
