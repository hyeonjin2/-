import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드
public class Main {

	static int N, M;
	static final int INF = 10_000_000;
	static int[][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		// 거리에 대한 2차원 배열 초기화
		D = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 자기 자신으로 가는 길은 최소비용 0
				if (i == j) {
					D[i][j] = 0;
					continue;
				}
				D[i][j] = INF;
			}
		}

		// 인접리스트 입력 받기
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			D[from][to] = Math.min(D[from][to], weight);
		}
		floydWarshall();
		// 출력
		print(D);
	}

	private static void floydWarshall() {
		for (int t = 1; t <= N; t++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					D[s][e] = Math.min(D[s][e], D[s][t] + D[t][e]);
				}
			}
		}

	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (D[i][j] == INF) {
					sb.append(0 + " ");
				} else {
					sb.append(D[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}