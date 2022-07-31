import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int arr1[] = new int[M];
		str = br.readLine();
		st = new StringTokenizer(str);
		for (int i = 0; i < M; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = N - 1;
		int mid;
		int[] count = new int[M];
		for (int i = 0; i < M; i++) {
			start = 0;
			end = N - 1;
			while (start <= end) {
				mid = (start + end) / 2;
				if (arr[mid] == arr1[i]) {
					count[i] = 1;
					break;
				} else if (arr[mid] < arr1[i]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		for (int i : count) {
			System.out.println(i);
		}
	}
}