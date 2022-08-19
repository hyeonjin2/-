import java.util.Scanner;

public class Solution {
	static String src = "3\r\n" + "3\r\n" + "1 2 4\r\n" + "3\r\n" + "1 2 3\r\n" + "9\r\n" + "1 2 3 5 6 4 7 8 9";
	static int ans;
	static int N;
	//static int[] weight;//이렇게 하면 시간초과
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//sc = new Scanner(src);
		int TC = sc.nextInt();
		StringBuilder buffer = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			ans = 0;

			N = sc.nextInt(); // 추갯수
			int[] weight = new int[N];// 추무게 저장 배열
			boolean[] selected = new boolean[N];// 완성 순열값 저장 배열

			// input
			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			}

			// 새 순열 만들어 내면서 그 때의 경로길이 계산 후 제일 짧은 길이 찾기
			//0:left, 0:right, cnt: 올려 놓은 추의 갯수(점점 늘어날 것임)
			check(0, 0, 0,selected, weight);//
			buffer.append("#" + tc + " " + ans + "\n");
		}		
		System.out.println(buffer);	
	}

	//추개수
	static void check(int cnt, int left, int right, boolean selected[], int[] weight) {
		if(left < right)//오른쪽이 더 무거워->안됨
			return;
		
		if(cnt == weight.length) {//오른쪽이 더 무겁지 않은데 모든 추를 다 사용했음->한가지 경우 완성!
			ans++;
			return;
		}
				
		for(int i = 0; i < weight.length;i++) {
			if(selected[i]) 
				continue;
	
			selected[i] = true;
			check(cnt+1, left+weight[i], right, selected, weight);//왼쪽에 놔봄
			check(cnt+1, left, right+weight[i], selected, weight);//오른쪽에 놔봄
			selected[i] = false;	
		}
	}

}