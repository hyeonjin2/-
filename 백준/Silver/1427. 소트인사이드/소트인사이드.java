import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] a = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			a[i] = str.charAt(i) - 48;
		}
		Arrays.sort(a);
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i]);
		}
	}

}
