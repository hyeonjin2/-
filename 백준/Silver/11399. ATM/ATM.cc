#include<iostream>
#include<algorithm>
using namespace std;

const int MAX = 1000;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int num;
	cin >> num;

	int a[MAX];

	for (int i = 0; i < num; i++) {
		cin >> a[i];
	}

	sort(a, a + num);

	int time = 0;
	for (int i = 0; i < num; i++) {
		for (int j = 0; j <= i; j++) {
			time += a[j];
		}
	}

	cout << time << endl;

	return 0;
}