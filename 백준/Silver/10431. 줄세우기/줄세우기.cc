#include <iostream>
using namespace std;

int main() {
	// 1. 자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
	// 2. 자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다.
	//    이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.

	// 학생들이 총 몇번 뒤로 물러서게 될까

	int tc;
	cin >> tc;

	int* arr = new int[20];

	for (int t = 0; t < tc; t++) {
		int ans = 0;
		int max = 0;
		int T;
		cin >> T;
		for (int i = 0; i < 20; i++) {
			cin >> arr[i];
			// 키가 큰 학생이 없다면 그 자리에 선다.
			if (max < arr[i]) {
				max = arr[i];
			}
			// 키가 큰 학생이 있다면
			else {
				// 그중 가장 앞에 있는 학생의 바로 앞에 선다.
				// 나보다 바로 다음 큰 학생 찾기
				int cnt = 0;
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[i]) {
						cnt++;
					}
				}
				ans += cnt;
			}
		}
		cout << T << " " << ans << "\n";
	}

	return 0;
}