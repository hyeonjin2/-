import java.util.Scanner;

public class Main {

	static int r;
	static int[] input;
	static int[] numbers;
	static boolean[] visited;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		input = new int[] { 1, 5, 10, 50 };
		numbers = new int[r];
		visited = new boolean[1001];
		totalCnt = 0;
		comb(0, 0, 0);
		System.out.println(totalCnt);
	}

	private static void comb(int cnt, int start, int sum) {
		if (cnt == r) {
			if (!visited[sum]) {
				totalCnt++;
				visited[sum] = true;
			}
			return;
		}
		for (int i = start; i < 4; i++) {
			comb(cnt + 1, i, sum + input[i]);
		}
	}
}