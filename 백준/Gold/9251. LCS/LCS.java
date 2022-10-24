import java.util.Scanner;

// LCS
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine().trim();
		String s2 = sc.nextLine().trim();

		int N = s1.length();
		int M = s2.length();

		int[][] d = new int[N + 1][M + 1]; // d[i][j]:s1의 i번째까지의 수열과 s2의 j번째까지의 수열을 비교했을 때 얻을 수 있는 가장 긴 수열의 길이

		for (int i = 1; i <= N; i++) {
			char cur = s1.charAt(i - 1);
			for (int j = 1; j <= M; j++) {
				if (cur == s2.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1] + 1;
				} else {
					d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
				}
			}
		}
		System.out.println(d[N][M]);
	}

}
