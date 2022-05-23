#include<iostream>
#include<algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int arr[1000001];
	int n;

	cin >> n;
	
	// 배열 초기화
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	// 배열 정렬
	sort(arr, arr + n);

	
	// 배열 출력
	for (int i = 0; i < n; i++) {
		cout << arr[i] << "\n";
	}

	return 0;
}