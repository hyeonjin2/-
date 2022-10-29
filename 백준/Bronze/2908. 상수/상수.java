import java.util.Scanner;

// 상수
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.next().toCharArray();
		char[] s2 = sc.next().toCharArray();
		int n1 = 0;
		int n2 = 0;
		for (int i = 2; i >= 0; i--) {
			n1 += (s1[i] - '0') * Math.pow(10, i);
			n2 += (s2[i] - '0') * Math.pow(10, i);
		}
		if (n1 > n2)
			System.out.println(n1);
		else
			System.out.println(n2);
	}

}