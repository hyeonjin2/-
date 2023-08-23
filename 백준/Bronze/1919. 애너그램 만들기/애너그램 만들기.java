import java.util.Scanner;

// 애너그램 만들기
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] word1 = sc.nextLine().toCharArray();
		char[] word2 = sc.nextLine().toCharArray();

		int[] arr1 = new int[26];
		int[] arr2 = new int[26];

		for (int i = 0; i < word1.length; i++) {
			arr1[word1[i] - 'a']++;
		}
		for (int i = 0; i < word2.length; i++) {
			arr2[word2[i] - 'a']++;
		}

		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (arr1[i] != arr2[i]) {
				cnt += Math.abs(arr1[i] - arr2[i]);
			}
		}
		System.out.println(cnt);
	}

}