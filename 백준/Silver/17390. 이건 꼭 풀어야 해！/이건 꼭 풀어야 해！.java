import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		Integer[] numbers = new Integer[N];
		long[] sum = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers, (e1, e2) -> {
			return e1 - e2;
		});
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				sum[i] = numbers[i];
				continue;
			}
			sum[i] = sum[i - 1] + numbers[i];
		}
		long result = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (start == 0) {
				result = sum[end];
			} else {
				result = sum[end] - sum[start - 1];
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}