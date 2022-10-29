import java.util.Scanner;
import java.util.StringTokenizer;

// 단어의 개수
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = st.countTokens();
		System.out.println(n);
	}

}