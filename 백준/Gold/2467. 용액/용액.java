import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 용액
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = N - 1;
		int min = Integer.MAX_VALUE;
		int r1 = start;
		int r2 = end;
		while (start < end) {
			int n1 = nums[start];
			int n2 = nums[end];
			int result = n1 + n2;
			if (Math.abs(result) < min) {
				r1 = n1;
				r2 = n2;
				min = Math.abs(result);
			}
			if (result < 0) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(r1 + " " + r2);
	}

}
