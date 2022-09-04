import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파티
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

	static class Vertex {
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	}

	static int V, E, start;
	static Node[] adjList, reverse_adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		adjList = new Node[V + 1];
		reverse_adjList = new Node[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, weight, adjList[from]);
			reverse_adjList[to] = new Node(from, weight, reverse_adjList[to]);
		}

		int[] D1 = dijkstra(adjList); // start -> 현재정점까지 최소비용
		int[] D2 = dijkstra(reverse_adjList); // 현재정점 -> start까지 최소 비용
//		int[] pqD1 = dijkstraPQ(adjList);
//		int[] pqD2 = dijkstraPQ(reverse_adjList);
		int max1 = 0;
		int max2 = 0;

		for (int i = 1; i <= V; i++) {
			int sum = D1[i] + D2[i];
			max1 = Math.max(max1, sum);
		}
//		for (int i = 1; i <= V; i++) {
//			int sum = pqD1[i] + pqD2[i];
//			max2 = Math.max(max2, sum);
//		}
		System.out.println(max1);
	}

	private static int[] dijkstra(Node[] adjList) {
		int[] D = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		Arrays.fill(D, Integer.MAX_VALUE);

		D[start] = 0;
		int min, minVertex;

		for (int i = 0; i < V; i++) {
			// step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
			// 방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			min = Integer.MAX_VALUE;
			minVertex = -1;

			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
			}
			// step2. 방문처리
			visited[minVertex] = true;
			// step3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && D[temp.vertex] > D[minVertex] + temp.weigth) {
					D[temp.vertex] = D[minVertex] + temp.weigth;
				}
			}
		}
		return D;
	}

	private static int[] dijkstraPQ(Node[] adjList) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pq.offer(new Vertex(start, 0));

		int[] D = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;

		while (!pq.isEmpty()) {
			Vertex curVertex = pq.poll();
			int cur = curVertex.no;

			if (!visited[cur]) {
				visited[cur] = true;

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					if (!visited[temp.vertex] && D[temp.vertex] > D[cur] + temp.weigth) {
						D[temp.vertex] = D[cur] + temp.weigth;
						pq.add(new Vertex(temp.vertex, D[temp.vertex]));
					}
				}
			}
		}

		return D;
	}
}