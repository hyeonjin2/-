import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 앱
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] memory = new int[N + 1];
		int[] cost = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0; // 모든 비용을 합친 값->최악의 경우에 대한 최대 비용
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}

		int[][] d = new int[N + 1][sum + 1]; // i만큼 비용을 사용하여 앱을 비활성화했을 때 확보할 수 있는 최대 메모리
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= sum; j++) {
				if (cost[i] <= j) {
					d[i][j] = Math.max(d[i - 1][j], memory[i] + d[i - 1][j - cost[i]]);
				}
				d[i][j] = Math.max(d[i][j], d[i - 1][j]);
			}
		}
		int ans = 0;
		for (int i = 0; i <= sum; i++) {
			if (d[N][i] >= M) {
				ans = i;
				break;
			}
		}
//		print(d);
		System.out.println(ans);
	}

	private static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}