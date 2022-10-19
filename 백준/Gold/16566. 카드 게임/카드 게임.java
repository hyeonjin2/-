import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 카드 게임
public class Main {

	static int M;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		set();
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(st.nextToken());
			// 입력보다 큰 수 중 최소값 구하기
			int minInd = upper_bound(nums, temp);
			// minInd값이 사용됐다면 그 다음 값을 찾아야함 -> ind
			int ind = find(minInd);
			sb.append(nums[ind]).append("\n");
			// ind 사용처리하기
			union(ind, ind + 1);
		}
		System.out.println(sb);
	}

	private static int upper_bound(int[] arr, int value) {
		int low = 0;
		int high = arr.length;
		while (low < high) {
			final int mid = low + (high - low) / 2;
			if (value >= arr[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private static void set() {
		parents = new int[M + 1];
		for (int i = 1; i < M; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[aRoot] = bRoot;
		}
	}

}