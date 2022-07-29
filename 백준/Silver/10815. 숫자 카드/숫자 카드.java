import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int[] list1 = new int[N];
		for (int i = 0; i < N; i++) {
			list1[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		str = br.readLine();
		st = new StringTokenizer(str);
		int[] list2 = new int[M];
		int[] result = new int[M];
		for (int i = 0; i < M; i++) {
			list2[i] = Integer.parseInt(st.nextToken());
		}
		// list1 정렬 후 가운데 값 리턴해서 list2[i]와 비교해서 이분 탐색 ㄱㄱ
		Arrays.sort(list1);
		for (int i = 0; i < M; i++) {
			int start = 0;
			int end = N - 1;
			int mid = (start + end) / 2;
			while (start <= end) {
				if (list1[mid] == list2[i]) {
					result[i] = 1;
					break;
				} else if (list1[mid] <= list2[i]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
				mid = (start + end) / 2;
			}
		}
		for (int i = 0; i < M; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
