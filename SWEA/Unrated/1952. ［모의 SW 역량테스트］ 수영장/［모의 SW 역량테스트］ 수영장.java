import java.util.Scanner;

public class Solution {

	static int TC = 0;
	static int Ans;
	static int day, month, month3, year;
	static int[] map = new int[12];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			day = sc.nextInt();
			month = sc.nextInt();
			month3 = sc.nextInt();
			year = sc.nextInt();

			for (int i = 0; i < 12; i++) {
				map[i] = sc.nextInt();
			}

			Ans = year;
			dfs(0, 0);

			System.out.println("#" + t + " " + Ans);
		}
	}

	private static void dfs(int index, int sum) {
		// 가지치기
		if (sum > Ans)
			return;
		// 종료조건
		if (index >= 12) {
			Ans = Math.min(Ans, sum);
			return;
		}
		// 실행하고 다음 재귀호출
		// 사용일이 0일이면 다음달로 이동
		if (map[index] == 0) {
			dfs(index + 1, sum);
			return;
		}
		// 1일권
		dfs(index + 1, sum + map[index] * day);
		// 1달권
		dfs(index + 1, sum + month);
		// 3달권
		dfs(index + 3, sum + month3);

	}
}