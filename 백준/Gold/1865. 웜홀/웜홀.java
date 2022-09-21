import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 웜홀
public class Main {

	static class Node {
		int to, weight;
		Node next;

		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static final int INF = 25_000_000;
	static int N, M, W;
	static int[] D;
	static Node[] adjList;
	static Edge[] edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			adjList = new Node[N + 1];
			edgeList = new Edge[M + W];

			for (int i = 0; i < M + W; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				if (i < M) {
					adjList[from] = new Node(to, weight, adjList[from]);
					adjList[to] = new Node(from, weight, adjList[to]);
				} else {
					weight *= (-1);
					adjList[from] = new Node(to, weight, adjList[from]);
				}
			}

			String Ans = "NO";
			for (int i = 1; i <= N; i++) {
				if (bellmanford(i)) {
					Ans = "YES";
					break;
				}
			}
			sb.append(Ans).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean bellmanford(int start) {
		D = new int[N + 1];
		Arrays.fill(D, INF);
		D[start] = 0;

		boolean flag = false;
		// n번 반복 (음수 간선 순환 체크안하려면 n-1번 반복
		for (int i = 0; i < N; i++) {
			flag = false;
			// 매 반복마다 모든 간선을 확인
			for (int j = 1; j <= N; j++) {
				for (Node temp = adjList[j]; temp != null; temp = temp.next) {
					if (D[j] != INF && D[temp.to] > D[j] + temp.weight) {
						D[temp.to] = D[j] + temp.weight;

						flag = true;
					}
				}
			}
			// 더 이상 최단거리로 업데이트 되지 않으면 이미 최단거리를 다 찾은 것이므로 반복문 종료
			if (!flag)
				break;
		}

		// flag=true이면 N-1까지 계속 업데이트가 발생한 경우
		// N번째도 업데이트가 발생하면 음수 사이클 존재
		if (flag) {
			for (int i = 1; i <= N; i++) {
				for (Node temp = adjList[i]; temp != null; temp = temp.next) {
					if (D[i] != INF && D[temp.to] > D[i] + temp.weight) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
