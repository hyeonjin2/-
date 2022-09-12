import java.util.Scanner;

// N과 M(2)
public class Main {

	static int N, M;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		comb(0, 1);
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			print(numbers);
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void print(int[] numbers) {
		for (int i = 0; i < M; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}