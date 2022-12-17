import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기
public class Main {

	static int N, groupInd, ans;
	static int[][] map;
	static int[][] group;

	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		group = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 그룹 짓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 바다가 아니고, 그룹이 없는 상태면 새로운 그룹 만들러 가기
				if (map[i][j] != 0 && group[i][j] == 0) {
					setGroup(i, j, ++groupInd);
				}
			}
		}
		// 최소다리 길이 구하기
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (group[i][j] != 0) {
					getBridge(i, j);
				}
			}
		}
		System.out.println(ans);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void getBridge(int i, int j) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(i, j, 0));
		boolean[][] visited = new boolean[N][N];
		visited[i][j] = true;
		int curGroup = group[i][j];

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || group[nx][ny] == curGroup) {
					continue;
				}
				visited[nx][ny] = true;
				if (map[nx][ny] == 0) {
					queue.offer(new Point(nx, ny, cnt + 1));
				} else {
					ans = Math.min(cnt, ans);
				}
			}
		}

	}

	private static void setGroup(int i, int j, int groupInd) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(i, j, 0));
		group[i][j] = groupInd;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 0 || group[nx][ny] != 0) {
					continue;
				}
				group[nx][ny] = groupInd;
				queue.offer(new Point(nx, ny, 0));
			}
		}
	}

}