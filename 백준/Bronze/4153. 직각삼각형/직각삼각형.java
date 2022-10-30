import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 직각 삼각형
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;
			int temp = arr[1] * arr[1] + arr[0] * arr[0];
			String ans = (arr[2] * arr[2]) == temp ? "right" : "wrong";
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}