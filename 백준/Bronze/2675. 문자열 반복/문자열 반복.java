import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 반복
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < N; j++) {
					sb.append(str.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}