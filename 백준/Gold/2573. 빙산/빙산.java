import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 빙산
public class Main {

	static int N, M;
	static int[][] map, copy;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy = new int[N][M];
		queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
				if (map[i][j] != 0)
					queue.offer(new Point(i, j));
			}
		}
//		print(map);
		// 1. 빙산이 녹는다.
		int Ans = 1;
		while (true) {
			bfs();
			// 2. 빙산이 2덩어리 이상으로 쪼개졌는지 확인한다.
			if (queue.isEmpty()) {
				Ans = 0;
				break;
			}
			Point start = queue.peek();
			boolean[][] visited = new boolean[N][M];
			boolean isOne = dfs(start, visited);
			if (!isOne)
				break;
			// 2번이 발생하지 않으면 반복한다.
			Ans++;
		}
		System.out.println(Ans);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static boolean dfs(Point start, boolean[][] visited) {
		Stack<Point> stack = new Stack<>();
		stack.push(start);
		visited[start.x][start.y] = true;
		int count = 1;
		while (!stack.isEmpty()) {
			Point cur = stack.pop();
			int x = cur.x;
			int y = cur.y;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0)
					continue;
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					stack.push(new Point(nx, ny));
					count++;
				}
			}
		}
		if (count == queue.size())
			return true;
		return false;
	}

	private static void bfs() {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int count = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] == 0)
					count++;
			}
			copy[x][y] = map[x][y] - count >= 0 ? map[x][y] - count : 0;
			if (copy[x][y] != 0) {
				queue.offer(new Point(x, y));
			}
		}
//		print(copy);
		copy(copy, map);
	}

	private static void copy(int[][] arr1, int[][] arr2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr2[i][j] = arr1[i][j];
			}
		}
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
