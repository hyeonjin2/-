#include<iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a, b;
	int a1, b1;
	int r1, r2;// r1 = 최대공약수, r2 = 최소공배수
	bool find = false;

	cin >> a >> b;

	if (a < b) {
		for (int i = 2; i <= a; i++) {
			if (a%i == 0 && b%i == 0) {
				r1 = i;
				a1 = a / r1;
				b1 = b / r1;
				r2 = a1 * b1*r1;
				find = true;
			}
		}
		if (!find) {
			r1 = 1;
			r2 = a * b;
		}
	}
	else {
		for (int i = 2; i <= b; i++) {
			if (a%i == 0 && b%i == 0) {
				r1 = i;
				a1 = a / r1;
				b1 = b / r1;
				r2 = a1 * b1*r1;
				find = true;
			}
		}
		if (!find) {
			r1 = 1;
			r2 = a * b;
		}
	}

	cout << r1 << "\n" << r2 << "\n";

	return 0;
}