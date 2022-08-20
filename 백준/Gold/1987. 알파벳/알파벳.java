import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited; // 지나온 알파벳들을 저장할 배열
	static int[][] map;
	static int n, m, Ans;

	static class Alpabet {
		Point p;
		int val;

		public Alpabet(Point p, int val) {
			this.p = p;
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		visited = new boolean[26];
		dfs(new Alpabet(new Point(0, 0), map[0][0]), 0);
		System.out.println(Ans);
	}

	// 4방 탐색 델타 배열 상,하,좌,우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void dfs(Alpabet cur, int count) {
		Point p = cur.p;
		// 같은 알파벳을 발견했을 경우 count 확인 후 리턴
		if (visited[map[p.x][p.y]]) {
			Ans = Math.max(Ans, count);
			return;
		}
		// 다른 알파벳인 경우 탐색
		visited[map[p.x][p.y]] = true;
		for (int d = 0; d < 4; d++) {
			Point np = new Point(p.x + dx[d], p.y + dy[d]);
			if (np.x >= 0 && np.x < n && np.y >= 0 && np.y < m) {
				Alpabet next = new Alpabet(np, map[np.x][np.y]);
				dfs(next, count + 1);
			}
		}
		// 다른 루트로 DFS 탐색하기 위해 visited 배열 초기화
		visited[map[p.x][p.y]] = false;
	}
}