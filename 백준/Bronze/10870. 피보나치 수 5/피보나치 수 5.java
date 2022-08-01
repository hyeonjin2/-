import java.util.Scanner;

public class Main {
	static int[] arr;

	static int fibonacci1(int n) {
		if (arr[n] == 0 && n < 2) {
			arr[n] = n;
		} else {
			if (arr[n] == 0)
				arr[n] = fibonacci1(n - 1) + fibonacci1(n - 2);
		}
		return arr[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1];
		System.out.println(fibonacci1(n));
	}
}