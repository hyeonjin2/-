import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 줄 세우기
public class Main {

	static int V, E;
	static List<Integer>[] adjList;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		inDegree = new int[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			inDegree[to]++;
		}
		List<Integer> result = sort();
		if (result.size() == V) {
			for (Integer i : result) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

	private static List<Integer> sort() {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= V; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			for (int i = 0; i < adjList[cur].size(); i++) {
				int temp = adjList[cur].get(i);
				if (--inDegree[temp] == 0) {
					queue.offer(temp);
				}
			}
		}

		return result;
	}
}