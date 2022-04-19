#include<iostream>
#include<stdio.h>
using namespace std;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int test, num, score;

	cin >> test;

	while (test) {

		float count = 0;
		float sum = 0;
		float avg;
		int scores[1000] = { -1, };

		cin >> num;
		
		for (int i = 0; i < num; i++) {
			cin >> score;
			scores[i] = score;
			sum += score;
		}

		avg = sum / num;

		for (int i = 0; i < num; i++) {
			if (scores[i] > avg) {
				count++;
			}
		}

		float result;

		result = count / num * 100;

		printf("%.3f%s\n", result,"%");

		test--;
	}

	return 0;
}