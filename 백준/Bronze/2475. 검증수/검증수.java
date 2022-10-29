import java.util.Scanner;
import java.util.StringTokenizer;

// 검증 수
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int size = st.countTokens();
		int sum = 0;
		for (int i = 0; i < size; i++) {
			int cur = Integer.parseInt(st.nextToken());
			sum += cur * cur;
		}
		System.out.println(sum % 10);
	}

}