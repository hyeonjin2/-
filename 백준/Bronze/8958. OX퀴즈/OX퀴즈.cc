#include<iostream>
#include<string>

using namespace std;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int num;
	string a;

	cin >> num;

	for (int i = 0; i < num; i++) {

		cin >> a;

		int sum = 0;
		int count = 0;

		for (int j = 0; j < a.size(); j++) {
			if (a[j] == 'O') {
				count++;
				sum += count;
			}
			else {
				count = 0;
			}
		}
		cout << sum << endl;
	}
	return 0;
}