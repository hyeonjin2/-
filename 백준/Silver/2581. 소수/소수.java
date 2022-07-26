import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean find = false;
		boolean findCheck = false;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = m; i <= n; i++) {
			find = false;
			if (i == 1)
				find = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					find = true;
					break;
				}
			}
			if (!find) {
				sum += i;
				if (min > i)
					min = i;
				findCheck = true;
			}
		}

		if (!findCheck) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}