import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int Ans;
	static int[][] matrix;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 간선의 수
			int N = Integer.parseInt(st.nextToken());
			// 시작점
			int start = Integer.parseInt(st.nextToken());
			// 배열 초기화
			matrix = new int[101][101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = 1;
			}
			bfs(start);
			sb.append("#").append(tc).append(" ").append(Ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited = new boolean[101];
		visited[start] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			Ans = 0;
			for (int k = 0; k < size; k++) {
				int cur = queue.poll();
				Ans = Math.max(Ans, cur);
				for (int i = 0; i < 101; i++) {
					if (!visited[i] && matrix[cur][i] != 0) {
						visited[i] = true;
						queue.offer(i);
					}
				}
			}
		}
	}

}