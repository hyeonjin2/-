#include<iostream>
using namespace std;

int main() {
	
	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int num, a, count;
	bool find;

	cin >> num;
	count = num;

	for (int k = 0; k < num; k++) {

		cin >> a;

		find = false;

		// 1은 소수 X
		if (a == 1) {
			count--;
		}
		else {
			for (int i = 2; i < a; i++) {
				if (a%i == 0) {
					find = true;
				}
			}
		}
		if (find&&a != 2)
			count--;
	}

	cout << count << endl;

	return 0;
}