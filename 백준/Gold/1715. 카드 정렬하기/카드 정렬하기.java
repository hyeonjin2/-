import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 카드 정렬하기
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int Ans = 0;
		if (N > 1) {
			while (!pq.isEmpty()) {
				int sum = pq.poll();
				int cur = pq.poll();
				sum += cur;
				Ans += sum;
				if (pq.isEmpty()) {
					break;
				}
				pq.offer(sum);
			}
		}
		System.out.println(Ans);
	}
}
