import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 스타트링크
public class Main {

	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();

		ans = Integer.MAX_VALUE;
		bfs(F, S, G, U, D);
		if (ans == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}

	private static void bfs(int max, int start, int goal, int u, int d) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { start, 0 });

		boolean[] visited = new boolean[max + 1];
		visited[start] = true;

		while (!queue.isEmpty()) {
			int[] curList = queue.poll();
			int cur = curList[0];
			int cnt = curList[1];
			if (cur == goal) {
				ans = Math.min(ans, cnt);
				return;
			}
			if (cur + u <= max && !visited[cur + u]) {
				queue.offer(new int[] { cur + u, cnt + 1 });
				visited[cur + u] = true;
			}
			if (cur - d >= 1 && !visited[cur - d]) {
				queue.offer(new int[] { cur - d, cnt + 1 });
				visited[cur - d] = true;
			}
		}
	}

}