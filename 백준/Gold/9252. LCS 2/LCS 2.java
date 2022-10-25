import java.util.Scanner;
import java.util.Stack;

// LCS 2
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine().trim();
		String s2 = sc.nextLine().trim();

		int N = s1.length();
		int M = s2.length();
		int[][] d = new int[N + 1][M + 1];
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
		Stack<Character> stack = new Stack<>();
		int i = N;
		int j = M;
		while (i != 0 && j != 0) {
			// 위쪽 값과 같은 경우, 위쪽으로 가기
			if (d[i - 1][j] == d[i][j]) {
				i--;
			}
			// 왼쪽 값과 같은 경우, 왼쪽으로 가기
			else if (d[i][j - 1] == d[i][j]) {
				j--;
			}
			// 둘이 같으면 대각선 위로 가기
			else {
				stack.push(s1.charAt(i - 1));
				i--;
				j--;
			}
		}
		String ans = "";
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		System.out.println(ans.length());
		if (ans.length() != 0)
			System.out.println(ans);
	}

}