import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 계단 오르기
public class Main {

	static int N, Ans;
	static int[] steps, sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		steps = new int[301];
		for (int i = 1; i <= N; i++) {
			steps[i] = Integer.parseInt(br.readLine());
		}
		sum = new int[301];
		sum[1] = steps[1];
		sum[2] = steps[1] + steps[2];
		sum[3] = Math.max(steps[1], steps[2]) + steps[3];
		for (int i = 4; i <= N; i++) {
			sum[i] = Math.max(sum[i - 3] + steps[i - 1], sum[i - 2]) + steps[i];
		}
		System.out.println(sum[N]);
	}
}
