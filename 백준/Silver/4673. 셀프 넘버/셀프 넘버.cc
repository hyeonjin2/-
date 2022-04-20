#include<iostream>
using namespace std;

bool num[10001];

int d(int n) {
	
	int result = n;

	while (n > 0) {
		result += n % 10;
		n /= 10;
	}

	return result;
}

void self_number() {
	int number;

	num[1] = false;

	for (int i = 0; i <= 10000; i++) {
		if (i <= 10000) {
			number = d(i);
			if (number <= 10000)
				num[number] = true;
		}
	}
}

int main() {

	self_number();

	for (int i = 1; i <= 10000; i++) {
		if (!num[i])
			cout << i << endl;
	}

	return 0;
}