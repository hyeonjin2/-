import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 알고스팟
public class Main {

	static class Spot implements Comparable<Spot> {
		int x, y;
		int cnt;

		public Spot(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Spot o) {
			return this.cnt - o.cnt;
		}
	}

	static int N, M, min;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
//		print(map);
		visited = new boolean[N][M];

		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		PriorityQueue<Spot> pq = new PriorityQueue<>();
		pq.offer(new Spot(0, 0, 0));
		visited[0][0] = true;
		while (!pq.isEmpty()) {
			Spot curSpot = pq.poll();
			int x = curSpot.x;
			int y = curSpot.y;
			int cnt = curSpot.cnt;
			if (cnt >= min)
				continue;
			if (x == N - 1 && y == M - 1) {
				min = Math.min(min, cnt);
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;
				if (map[nx][ny] == 1) {
					pq.offer(new Spot(nx, ny, cnt + 1));
				} else {
					pq.offer(new Spot(nx, ny, cnt));
				}
				visited[nx][ny] = true;
			}
		}
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}