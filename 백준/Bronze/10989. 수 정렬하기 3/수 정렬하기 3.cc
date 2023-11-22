#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int N;
	cin >> N;
	
	int* arr = new int[10001];

	for (int i = 0; i < 10001; i++) {
		arr[i] = 0;
	}

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;

		arr[num]++;
	}

	

	for (int i = 1; i < 10001; i++) {
		if (arr[i] > 0) {
			while (arr[i]-- > 0) {
				cout << i << "\n";
			}
		}
	}

	return 0;
}