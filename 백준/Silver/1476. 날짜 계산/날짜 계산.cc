#include <iostream>
using namespace std;

// 날짜 계산
int main() {
	int nums[3] = { 15,28,19 };
	int year[3];
	int result = 1;

	cin >> year[0] >> year[1] >> year[2];

	while (year[0] != 1 || year[1] != 1 || year[2] != 1) {
		year[0]--;
		year[1]--;
		year[2]--;

		for (int i = 0; i < 3; i++) {
			if (year[i] == 0)
				year[i] = nums[i];
		}
		result++;
	}

	cout << result;

	return 0;
}