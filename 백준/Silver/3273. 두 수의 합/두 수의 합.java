import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 배열의 크기 n
		int n = Integer.parseInt(br.readLine());
		// 배열 초기화
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int num = Integer.parseInt(br.readLine());

		Arrays.parallelSort(arr);

		int count = 0;
		int start = 0;
		int end = n - 1;
		int sum = 0;

		while (start < end) {
			sum = arr[start] + arr[end];
			if (sum == num) {
				count++;
			}
			if (sum <= num) {
				start++;
			} else
				end--;
		}

		System.out.println(count);

	}

}