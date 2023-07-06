import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내려가기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] floor = new int[3];
		int[][] max = new int[3][N];
		int[][] min = new int[3][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		floor[0] = Integer.parseInt(st.nextToken());
		floor[1] = Integer.parseInt(st.nextToken());
		floor[2] = Integer.parseInt(st.nextToken());

		max[0][0] = floor[0];
		max[1][0] = floor[1];
		max[2][0] = floor[2];

		min[0][0] = floor[0];
		min[1][0] = floor[1];
		min[2][0] = floor[2];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			floor[0] = Integer.parseInt(st.nextToken());
			floor[1] = Integer.parseInt(st.nextToken());
			floor[2] = Integer.parseInt(st.nextToken());

			max[0][i] = Math.max(max[0][i - 1] + floor[0], max[1][i - 1] + floor[0]);
			max[1][i] = Math.max(max[0][i - 1] + floor[1], max[1][i - 1] + floor[1]);
			max[1][i] = Math.max(max[1][i], max[2][i - 1] + floor[1]);
			max[2][i] = Math.max(max[1][i - 1] + floor[2], max[2][i - 1] + floor[2]);

			min[0][i] = Math.min(min[0][i - 1] + floor[0], min[1][i - 1] + floor[0]);
			min[1][i] = Math.min(min[0][i - 1] + floor[1], min[1][i - 1] + floor[1]);
			min[1][i] = Math.min(min[1][i], min[2][i - 1] + floor[1]);
			min[2][i] = Math.min(min[1][i - 1] + floor[2], min[2][i - 1] + floor[2]);
		}

		int ans1 = Math.max(max[0][N - 1], max[1][N - 1]);
		ans1 = Math.max(ans1, max[2][N - 1]);

		int ans2 = Math.min(min[0][N - 1], min[1][N - 1]);
		ans2 = Math.min(ans2, min[2][N - 1]);

		System.out.println(ans1 + " " + ans2);
	}

}