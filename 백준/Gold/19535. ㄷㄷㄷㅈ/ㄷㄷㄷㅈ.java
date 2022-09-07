import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// ㄷㄷㄷㅈ
public class Main {

	static int V;
	static long cntD, cntG;
	static boolean[] visited;
	static List<Integer>[] lines;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		lines = new ArrayList[V + 1];

		for (int i = 0; i < V + 1; i++) {
			lines[i] = new ArrayList<>();
		}
		for (int i = 1; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			lines[from].add(to);
			lines[to].add(from);
		}
//		System.out.println(Arrays.toString(linesD));
		visited = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			long count = lines[i].size();
			if (count >= 3) {
				cntG += (long) count * (count - 1) * (count - 2) / 6;
			}
			visited[i] = true;
			for (int num : lines[i]) {
				long count2 = lines[num].size();
				if (!visited[num])
					cntD += (long) (count - 1) * (count2 - 1);
			}
		}
//		System.out.println(cntD);
//		System.out.println(cntG);
		if (cntD == cntG * 3) {
			System.out.println("DUDUDUNGA");
		} else if (cntD > cntG * 3) {
			System.out.println("D");
		} else if (cntD < cntG * 3) {
			System.out.println("G");
		}
	}
}