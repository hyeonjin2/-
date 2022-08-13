import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String target = "666";
		int count = 1;
		int num = 666;
		while (N != count) {
			num++;
			if (String.valueOf(num).contains(target)) {
				count++;
			}
		}
		System.out.println(num);
	}
}