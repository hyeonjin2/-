import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위 쌓기
public class Main {

	static int N, ans;
	static int[][] dices;
	static int[][] side;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dices = new int[N][6];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 6; i++) {
			// 1번 주사위 밑면 정하고 주사위 쌓기
			side = new int[N][4];
			setDice(i);
			// 옆 면 숫자의 최댓값 계산
			int result = calc();
			ans = Math.max(ans, result);
		}
		System.out.println(ans);
	}

	private static void setDice(int bottom) {
		int up = 0;

		if (bottom == 0 || bottom == 5) {
			up = 5 - bottom;

		} else if (bottom == 1 || bottom == 3) {
			up = 4 - bottom;

		} else if (bottom == 2 || bottom == 4) {
			up = 6 - bottom;

		}
		int ind = 0;
		for (int i = 0; i < 6; i++) {
			if (i == bottom || i == up)
				continue;
			side[0][ind++] = dices[0][i];
		}
		stackDice(1, dices[0][up]);
	}

	private static void stackDice(int num, int down) {
		if (num == N) {
			return;
		}
		int bottom = 0;
		for (int i = 0; i < 6; i++) {
			if (dices[num][i] == down) {
				bottom = i;
				break;
			}
		}
		int up = 0;
		if (bottom == 0 || bottom == 5) {
			up = 5 - bottom;

		} else if (bottom == 1 || bottom == 3) {
			up = 4 - bottom;

		} else if (bottom == 2 || bottom == 4) {
			up = 6 - bottom;

		}
		int ind = 0;
		for (int i = 0; i < 6; i++) {
			if (i == bottom || i == up)
				continue;
			side[num][ind++] = dices[num][i];
		}
		stackDice(num + 1, dices[num][up]);
	}

	private static int calc() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			Arrays.sort(side[i]);
			sum += side[i][3];
		}
		return sum;
	}
}
