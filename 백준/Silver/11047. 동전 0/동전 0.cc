#include<iostream>
using namespace std;

const int MAX = 10;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int N, K;
	int sum = 0;
	int a[MAX];

	cin >> N >> K;

	for (int k = 0; k < N; k++) {
		cin >> a[k];
	}

	for (int i = N-1; i >= 0; i--) {
		sum += K / a[i];
		K = K % a[i];
	}

	cout << sum << endl;

	return 0;
}