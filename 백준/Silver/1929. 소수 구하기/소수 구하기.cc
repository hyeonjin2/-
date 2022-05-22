#include<iostream>
#include<stdio.h>
#include<cmath>
using namespace std;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int min, max;
	int rt;

	cin >> min >> max;

	for (int i = min; i <= max; i++) {
		rt = sqrt(i);
		if (rt == 1 && i != 1) {// 2,3인 경우
			cout << i << endl;
			continue;
		}
		if (i % 2) {
			for (int j = 2; j <= rt; j++) {
				if (!(i%j))
					break;
				if (j == rt)
					printf("%d\n", i);
			}
		}
	}

	return 0;
}