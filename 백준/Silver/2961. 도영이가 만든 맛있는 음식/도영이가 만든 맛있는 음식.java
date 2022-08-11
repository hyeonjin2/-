import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, sour, bitter, diff;
	static int[][] ingredient;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ingredient = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken()); // 신맛 : 곱하기
			ingredient[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛 : 더하기
		}
		isSelected = new boolean[N];
		diff = Integer.MAX_VALUE;
		subSet(0);
		System.out.println(diff);
	}

	private static void subSet(int index) {
		if (index == N) {
			calc();
			return;
		}
		isSelected[index] = true;
		subSet(index + 1);
		isSelected[index] = false;
		subSet(index + 1);
	}

	private static void calc() {
		sour = 1;
		bitter = 0;
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				sour *= ingredient[i][0];
				bitter += ingredient[i][1];
			}
		}
		if (sour == 0 || bitter == 0) {
			return;
		}
		int tmp = Math.abs(sour - bitter);
		diff = Math.min(diff, tmp);
	}
}