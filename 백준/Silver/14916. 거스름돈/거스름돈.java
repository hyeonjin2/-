import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int Ans = 0;
		while (money > 0) {
			if (money % 5 != 0) {
				if (money >= 2) {
					money -= 2;
					Ans++;
				} else {
					Ans = -1;
					break;
				}
			} else {
				money -= 5;
				Ans++;
			}
		}
		System.out.println(Ans);
	}
}