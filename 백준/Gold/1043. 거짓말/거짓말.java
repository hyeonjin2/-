import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 거짓말
public class Main {

	static int N;
	static boolean[] knows;
	static int[] parents;
	static List<Integer>[] parties;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		knows = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for (int j = 0; j < K; j++) {
			int temp = Integer.parseInt(st.nextToken());
			knows[temp] = true;
		}

		make();

		int person1;
		parties = new ArrayList[M];

		// 각 사람들 파티에 합치기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			person1 = Integer.parseInt(st.nextToken());

			parties[i] = new ArrayList<>();
			parties[i].add(person1);
			for (int j = 0; j < k - 1; j++) {
				int person2 = Integer.parseInt(st.nextToken());
				parties[i].add(person2);
				// 사실을 아는 사람이 있는 경우
				union(person1, person2);
				person1 = person2;
			}
		}
		// 파티에 사실을 아는 사람 업데이트 하기
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (find(i) == find(j) && knows[i] != knows[j]) {
					knows[i] = true;
					knows[j] = true;
					visited[i] = true;
					visited[j] = true;
				}
			}
		}
		// 사실을 모르는 사람들만 있는 파티의 수 구하기
		int cnt = M;
		for (int i = 0; i < M; i++) {
			int person = parties[i].get(0);
			if (knows[person])
				cnt--;
		}
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot)
			parents[bRoot] = aRoot;

	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	// 모든 사람들이 알도록 바꾸기
	private static void setKnows(int index) {
		for (int i = 0; i < parties[index].size(); i++) {
			int person = parties[index].get(i);
			knows[person] = true;
		}
	}

}
