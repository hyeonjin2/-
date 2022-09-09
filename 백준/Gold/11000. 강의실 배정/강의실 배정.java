import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 강의실 배정
public class Main {

	static class Lecture implements Comparable<Lecture> {
		int start, end;

		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			return this.start == o.start ? this.end - o.end : this.start - o.start;
		}
	}

	static int N;
	static Lecture[] lectures;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lectures = new Lecture[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		PriorityQueue<Integer> result = getLecture();
		System.out.println(result.size());
	}

	private static PriorityQueue<Integer> getLecture() {
		PriorityQueue<Integer> result = new PriorityQueue<>();
		Arrays.sort(lectures);
		result.offer(lectures[0].end);
		for (int i = 1; i < N; i++) {
			if (result.peek() <= lectures[i].start) {
				result.poll();
			}
			result.offer(lectures[i].end);
		}
		return result;
	}
}