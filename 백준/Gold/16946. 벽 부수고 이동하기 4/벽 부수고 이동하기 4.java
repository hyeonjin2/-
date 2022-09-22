import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 4
public class Main {

	static int N, M;
	static int[][] map, group;
	static HashMap<Integer, Integer> hashmap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		group = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		// 그룹화 하기
		hashmap = new HashMap<>();
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && group[i][j] == 0) {
					hashmap.put(++index, bfs(i, j, index));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(count(i, j));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int count(int x, int y) {
		HashSet<Integer> set = new HashSet<>();
		if (map[x][y] == 0)
			return 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || group[nx][ny] == 0)
				continue;
			if (map[nx][ny] == 0)
				set.add(group[nx][ny]);
		}
		int sum = 1;
		for (int index : set) {
			sum += hashmap.get(index);
		}
		return sum % 10;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs(int x, int y, int index) {
		Queue<Point> queue = new ArrayDeque<>();
		group[x][y] = index;
		queue.add(new Point(x, y));
		int count = 1;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] == 0 && group[nx][ny] == 0) {
					group[nx][ny] = index;
					queue.add(new Point(nx, ny));
					count++;
				}
			}
		}
		return count;
	}
}