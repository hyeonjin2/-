#include<iostream>
using namespace std;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int num, count;
	string a;

	cin >> num;

	count = num;

	for (int i = 0; i < num; i++) {

		cin >> a;
		// 그룹 단어 검사
		for (int j = 0; j < a.length(); j++) {
			// 연속된 단어가 연속된 뒤에도 다시 등장하면 그룹단어 X
			if (a[j] != a[j + 1]) {
				for (int k = j + 1; k < a.length(); k++) {
					if (a[j] == a[k]) {
						count--;
						goto STOP;
					}
				}
			}
		}
	STOP:;
	}

	cout << count << endl;

	return 0;
}