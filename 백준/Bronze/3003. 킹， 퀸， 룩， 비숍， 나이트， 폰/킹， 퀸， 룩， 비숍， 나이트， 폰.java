import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sets = { 1, 1, 2, 2, 2, 8 };
		int[] result = new int[6];
		for (int i = 0; i < 6; i++) {
			result[i] = sets[i] - sc.nextInt();
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(result[i] + " ");
		}
	}
}