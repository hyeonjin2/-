import java.util.Arrays;
import java.util.Scanner;

// 알파벳 찾기
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();
		int[] alpabet = new int[26];
		Arrays.fill(alpabet, -1);
		for (int i = 0; i < arr.length; i++) {
			int ind = arr[i] - 'a';
			if (alpabet[ind] == -1)
				alpabet[ind] = i;
		}

		for (int i = 0; i < 26; i++) {
			System.out.print(alpabet[i] + " ");
		}
	}

}