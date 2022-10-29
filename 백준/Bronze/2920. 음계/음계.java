import java.util.Scanner;

// 음계
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] melody = new int[8];
		for (int i = 0; i < 8; i++) {
			melody[i] = sc.nextInt();
		}
		String ans = "";
		int diff = melody[0] - melody[1];
		if (diff == -1) {
			ans = "ascending";
		} else if (diff == 1) {
			ans = "descending";
		}
		for (int i = 1; i < 7; i++) {
			int temp = melody[i] - melody[i + 1];
			if (diff != temp) {
				ans = "mixed";
			}
		}
		System.out.println(ans);
	}
}