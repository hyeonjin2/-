import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 택배
public class Main {

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}

	static int V, E;
	static Node[] adjList;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(vertex, weight, adjList[from]);
			adjList[vertex] = new Node(from, weight, adjList[vertex]);
		}
		sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			// 다익스트라 메소드 실행
			dijkstra(i);
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0));

		boolean[] visited = new boolean[V + 1];
		int[] D = new int[V + 1];
		int[] route = new int[V + 1];

		Arrays.fill(D, Integer.MAX_VALUE);

		D[start] = 0;
		route[start] = start;

		while (!pq.isEmpty()) {
			Vertex minVertex = pq.poll();

			if (visited[minVertex.no])
				continue;
			visited[minVertex.no] = true;
			for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && D[temp.vertex] > D[minVertex.no] + temp.weight) {
					D[temp.vertex] = D[minVertex.no] + temp.weight;
					route[temp.vertex] = minVertex.no;
					pq.offer(new Vertex(temp.vertex, D[temp.vertex]));
				}
			}

		}

//		System.out.println(Arrays.toString(route));
		getRoute(start, route);
	}

	private static void getRoute(int start, int[] route) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= V; i++) {
			if (i == start) {
				sb.append("- ");
				continue;
			}
			int end = i;

			while (end != start) {
				stack.push(end);
				end = route[end];
			}
			sb.append(stack.pop() + " ");
		}
		sb.append("\n");
	}
}