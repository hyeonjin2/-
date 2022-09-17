import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 미로만들기
public class Main {

	static class Room implements Comparable<Room> {
		int x, y;
		int count;

		public Room(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public int compareTo(Room o) {
			return this.count - o.count;
		}
	}

	static int N, Ans, Cnt;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		Ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(Ans);
	}

	// 4방탐색 델타 배열
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		PriorityQueue<Room> pq = new PriorityQueue<>();
		pq.offer(new Room(0, 0, 0));
		boolean[][] visited = new boolean[N][N];
		while (!pq.isEmpty()) {
			Room cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int count = cur.count;
			if (count >= Ans)
				continue;
			if (x == N - 1 && y == N - 1) {
				Ans = Math.min(Ans, count);
				return;
			}
			boolean change = false;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (!isIn(nx, ny) || visited[nx][ny])
					continue;
				if (map[nx][ny] == 0) {
					pq.offer(new Room(nx, ny, count + 1));
					map[nx][ny] = 1;
					change = true;
				} else {
					pq.offer(new Room(nx, ny, count));
				}
				visited[nx][ny] = true;
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}