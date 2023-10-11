import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 문자열 교집합
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 첫번째 문자열 입력받기
			HashMap<String, Integer> hash1 = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				hash1.put(st.nextToken(), 1);
			}

			// 두번째 문자열 입력받기
			HashMap<String, Integer> hash2 = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				hash2.put(st.nextToken(), 1);
			}

			int result = 0;
			for (String str : hash1.keySet()) {
				if (hash2.get(str) != null) {
					result++;
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

}