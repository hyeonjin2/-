import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

// 피리 부는 사나이
public class Main {

	static int N, M, index;
	static final int INF = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] group;
	static HashMap<Integer, List<Point>> info;
	static HashSet<Integer> remove;
	static HashMap<Character, Integer> dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dir = new HashMap<>();
		dir.put('U', 0);
		dir.put('D', 1);
		dir.put('L', 2);
		dir.put('R', 3);

		info = new HashMap<>();
		remove = new HashSet<>();
		group = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (group[i][j] == 0) {
					List<Point> list = new ArrayList<>();
					info.put(++index, list);
					setGroup(i, j, index);
				}
			}
		}
		System.out.println(info.size() - remove.size());
//		print(group);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void setGroup(int i, int j, int ind) {
		List<Point> list = info.get(ind);
		list.add(new Point(i, j));
		info.put(ind, list);
		group[i][j] = ind;

		int d = dir.get(map[i][j]);
		int nx = i + dx[d];
		int ny = j + dy[d];

		if (group[nx][ny] == 0)
			setGroup(nx, ny, ind);
		else if (group[nx][ny] != group[i][j]) {
			// 그룹 2개 합치기
			List<Point> tlist = info.get(group[nx][ny]);
			tlist.addAll(list);
			info.put(group[nx][ny], tlist);
			remove.add(group[i][j]);
			group[i][j] = group[nx][ny];
		}
	}

	private static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}