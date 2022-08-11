import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, L;
	static int[][] ingredient; // 재료의 선호도와 칼로리를 담는 배열
	static int max, score, calorie;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 개수
			L = Integer.parseInt(st.nextToken()); // 칼로리 제한
			// 재료 배열 초기화
			ingredient = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());

			}
			max = 0;
			score = 0;
			calorie = 0;
			comb(0, 0);
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void comb(int cnt, int start) {
		if (calorie > L) {
			return;
		}
		if (cnt == N && calorie <= L) {
			max = Math.max(max, score);
			return;
		}
		for (int i = start; i < N; i++) {
			score += ingredient[i][0];
			calorie += ingredient[i][1];
			comb(cnt + 1, i + 1);
			score -= ingredient[i][0];
			calorie -= ingredient[i][1];
		}
		max = Math.max(max, score);
	}
}