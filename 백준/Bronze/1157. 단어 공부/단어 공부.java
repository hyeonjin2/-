import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			temp = (char) (temp < 97 ? temp : temp - 32);
			count[temp - 'A']++;
		}
		int max = -1;
		char result = '2';
		for (int i = 0; i < 26; i++) {
			if (max < count[i]) {
				max = count[i];
				result = (char) (i + 'A');
			}else if(max==count[i])
				result = '?';
		}
		System.out.println(result);
	}
}