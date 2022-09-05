import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 최소비용 구하기
public class Main {

	static class Node {
		int vertex, weigth;
		Node next;

		public Node(int vertex, int weigth, Node next) {
			this.vertex = vertex;
			this.weigth = weigth;
			this.next = next;
		}
	}

	static int V;
	static Node[] adjList;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		adjList = new Node[V + 1];

		StringTokenizer st;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, weight, adjList[from]);
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start, end);

		System.out.println(sb);
	}

	private static void dijkstra(int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>((v1, v2) -> v1.weigth - v2.weigth);
		queue.offer(new Node(start, 0, adjList[start]));

		int[] list = new int[V + 1];
		int[] D = new int[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);

		D[start] = 0;
		list[start] = 0;

		while (!queue.isEmpty()) {
			Node curVertex = queue.poll();
			int cur = curVertex.vertex;

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (D[temp.vertex] > D[cur] + temp.weigth) {
					queue.offer(new Node(temp.vertex, temp.weigth, null));
					D[temp.vertex] = D[cur] + temp.weigth;
					list[temp.vertex] = cur;
				}
			}
		}

		sb = new StringBuilder();
		sb.append(D[end]).append("\n");
		Stack<Integer> stack = new Stack<>();
		
		while (end != 0) {
			stack.push(end);
			end = list[end];
		}
		
		sb.append(stack.size()).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
	}
}
