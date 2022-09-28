import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사
public class Main {

	static class Consulting {
		int day, money;

		public Consulting(int day, int money) {
			this.day = day;
			this.money = money;
		}

	}

	static int N, Ans;
	static Consulting[] list;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new Consulting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i] = new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		flag = new boolean[N];
		dfs(0, 0, 0);
		System.out.println(Ans);
	}

	private static void dfs(int day, int money, int temp) {
		// 종료 조건
		if (day >= N) {
			if (day == N) {
				money += temp;
			}
			Ans = Math.max(Ans, money);
			return;
		}
		// 상담을 하는 경우 : 상담에 걸리는 날짜만큼 날짜 이동, 돈 더하기
		flag[day] = true;
		dfs(day + list[day].day, money + temp, list[day].money);
		// 상담을 안하는 경우 : 다음날로 넘어가고 돈 그대로
		flag[day] = false;
		dfs(day + 1, money + temp, 0);
	}
}