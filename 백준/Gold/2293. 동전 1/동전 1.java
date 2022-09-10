import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 동전 1
public class Main {

	static int N, M;
	static int[] coins, money;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		coins = new int[N];
		money = new int[M + 1];

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		makeMoney();
		System.out.println(money[M]);
	}

	private static void makeMoney() {
		money[0] = 1;
		for (int i = 0; i < N; i++) {
			for (int k = 1; k <= M; k++) {
				if (k >= coins[i]) {
					money[k] += money[k - coins[i]];
				}
			}
		}
	}
}