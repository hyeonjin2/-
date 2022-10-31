import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 친구비
public class Main {

	static int N, M, K;
	final static int INF = Integer.MAX_VALUE;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] money = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		makeSet();
		// 친구 관계 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		// 최소 비용 업데이트
		int[] minMoney = new int[N + 1];
		Arrays.fill(minMoney, INF);
		for (int i = 1; i <= N; i++) {
			if (minMoney[find(i)] >= money[i]) {
				minMoney[find(i)] = money[i];
			}
		}
		// 비용 계산하기
		int cost = 0;
		for (int i : minMoney) {
			if (i != INF)
				cost += i;
		}
		if (cost > K)
			System.out.println("Oh no");
		else
			System.out.println(cost);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

}