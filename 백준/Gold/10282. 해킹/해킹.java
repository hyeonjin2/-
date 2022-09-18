import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 해킹
public class Main {

	static class Node {
		int to, time;
		Node next;

		public Node(int to, int time, Node next) {
			this.to = to;
			this.time = time;
			this.next = next;
		}
	}

	static class Computer implements Comparable<Computer> {
		int no;
		int time;

		public Computer(int no, int time) {
			this.no = no;
			this.time = time;
		}

		@Override
		public int compareTo(Computer o) {
			return this.time - o.time;
		}
	}

	static int N;
	static final int INF = Integer.MAX_VALUE;
	static Node[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 수만큼 돌리기
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			adjList = new Node[N + 1];

			// 컴퓨터의 의존성 입력받기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				adjList[from] = new Node(to, time, adjList[from]);
			}
			int[] times = dijkstra(K);
			int max = 0;
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (times[i] < INF) {
					count++;
					if (max < times[i])
						max = times[i];
				}
			}
			sb.append(count + " " + max).append("\n");
		}
		System.out.println(sb);
	}

	private static int[] dijkstra(int start) {
		PriorityQueue<Computer> pq = new PriorityQueue<>();
		int[] D = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(D, INF);
		D[start] = 0;
		pq.offer(new Computer(start, 0));

		while (!pq.isEmpty()) {
			Computer cur = pq.poll();
			if (visited[cur.no])
				continue;
			visited[cur.no] = true;
			for (Node temp = adjList[cur.no]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && D[temp.to] > D[cur.no] + temp.time) {
					D[temp.to] = D[cur.no] + temp.time;
					pq.offer(new Computer(temp.to, D[temp.to]));
				}
			}
		}
		return D;
	}
}
