import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 음악프로그램
public class Main {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
	}

	static int N, M;
	static Node[] adjList;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N + 1];
		inDegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K - 1; j++) {
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
				from = to;
			}
		}
		List<Integer> list = topologySort();
		StringBuilder sb = new StringBuilder();
		// 출연 순서를 정하는 것이 불가능한 경우
		if (list.size() != N) {
			System.out.println(0);
		} else {
			for (Integer i : list) {
				sb.append(i).append("\n");
			}
			System.out.println(sb);
		}
	}

	private static List<Integer> topologySort() {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (--inDegree[temp.to] == 0) {
					queue.offer(temp.to);
				}
			}
		}
		return result;
	}
}