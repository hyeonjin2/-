import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int flag = 0;
			flag = checkNum(flag, N);

			int res = 1;

			while (flag != (Math.pow(2, 10) - 1)) {
				int temp = res * N;
				flag = checkNum(flag, temp);
				res++;
			}

			int ans = N * (res - 1);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static int checkNum(int flag, int num) {
		while (num / 10 != 0) {
			int temp = num % 10;
			flag = flag | (1 << temp);
			num = num / 10;
		}
		flag = flag | (1 << num);
		return flag;
	}

}