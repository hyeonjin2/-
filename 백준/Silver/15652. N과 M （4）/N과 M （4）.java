import java.util.Arrays;
import java.util.Scanner;

// N과 M(4)
public class Main {

	static int N, M;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];
		perm(0);
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int i : numbers) {
				sb.append(i + " ");
			}
			System.out.println(sb);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (cnt == 0) {
				numbers[cnt] = i;
			} else if (cnt > 0 && numbers[cnt - 1] <= i) {
				numbers[cnt] = i;
			} else {
				continue;
			}
			perm(cnt + 1);
		}
	}

}