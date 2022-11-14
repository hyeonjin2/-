import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소2
public class Main {

	static int N, M, min;
	static int[][] map, copy;
	static List<Point> viruses;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		viruses = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					viruses.add(new Point(i, j));
					map[i][j] = 0;
				}
			}
		}
		// 바이러스 놓기
		selected = new int[M]; // 놓여진 바이러스의 인덱스 번호를 저장할 배열
		min = Integer.MAX_VALUE;
		comb(0, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			copy = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					copy[i][j] = map[i][j];
				}
			}
			// 바이러스 퍼뜨리러 가기
			int result = spread();
			if (result >= 0) {
				min = Math.min(min, result);
			}
			return;
		}
		for (int i = start, size = viruses.size(); i < size; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int spread() {
		// 반복
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			Point v = viruses.get(selected[i]);
			queue.offer(v);
			copy[v.x][v.y] = 2;
		}
		// 빈 칸이 있는지 확인하기
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] == 0)
					temp++;
			}
		}
		if (temp == 0) {
			return 0;
		}
		int preCnt = 0;
		int postCnt = 0;
		int cnt = 0;
		while (true) {
			cnt++;
			// 바이러스 퍼트리기
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point cur = queue.poll();
				int x = cur.x;
				int y = cur.y;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || copy[nx][ny] != 0)
						continue;
					copy[nx][ny] = 2;
					queue.offer(new Point(nx, ny));
				}
			}
			// 빈 칸이 있는지 확인하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copy[i][j] == 0)
						postCnt++;
				}
			}
			if (postCnt == 0) {
				break;
			} else if (preCnt != postCnt) {
				preCnt = postCnt;
				postCnt = 0;
			} else if (preCnt == postCnt) {
				break;
			}
		}
		if (postCnt == 0) {
			return cnt;
		} else {
			return -1;
		}
	}

}
