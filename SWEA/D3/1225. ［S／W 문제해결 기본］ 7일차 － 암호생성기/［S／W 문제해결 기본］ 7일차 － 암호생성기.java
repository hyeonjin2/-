import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스 번호
			br.readLine();
			Queue<Integer> numbers = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine(), " ");
			// 큐 초기화 하기
			for (int i = 0; i < 8; i++) {
				numbers.offer(Integer.parseInt(st.nextToken()));
			}
			// 첫번째 수에서 1빼서 맨 뒤로 보내기
			int cnt = 1; // 빼는 수 1씩 증가
			// 첫번째 수 -cnt == 0 일 때 루프 탈출
			while (true) {
				int num = numbers.poll() - cnt;
				if (num <= 0) {
					num = 0;
					numbers.add(num);
					break;
				}
				numbers.add(num);
				if (cnt == 5)
					cnt = 1;
				else {
					cnt++;
				}
			}
			// 출력
			sb.append("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(numbers.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}