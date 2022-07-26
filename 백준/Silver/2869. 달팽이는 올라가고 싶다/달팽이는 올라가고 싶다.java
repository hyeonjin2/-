import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double daytime = sc.nextInt();
		double night = sc.nextInt();
		double stick = sc.nextInt();
		double day = (stick - night) / (daytime - night);
		System.out.printf("%.0f", Math.ceil(day));
	}
}
