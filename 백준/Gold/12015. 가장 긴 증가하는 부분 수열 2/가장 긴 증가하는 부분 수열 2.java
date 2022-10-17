import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열2
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int[] C = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(C, 0, size, numbers[i]);
			if (pos >= 0)
				continue;
			int insertPos = Math.abs(pos) - 1;
			C[insertPos] = numbers[i];
			if (insertPos == size)
				size++;
		}
		System.out.println(size);
	}
}
