import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// ACM Craft
public class Main {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static int N, target;
	static long Ans;
	static int[] time, inDegree, result;
	static Node[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			time = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			adjList = new Node[N + 1];
			inDegree = new int[N + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
			}
			target = Integer.parseInt(br.readLine());
			result = new int[N + 1];
			topologySort();

			sb.append(result[target]).append("\n");
		}
		System.out.println(sb);
	}

	private static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> time[e1] - time[e2]);
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				result[i] = time[i];
				pq.offer(i);
			}
		}
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				result[temp.to] = Math.max(result[temp.to], result[cur] + time[temp.to]);
				if (--inDegree[temp.to] == 0) {
					pq.offer(temp.to);
				}
			}
		}
	}
}