#include <iostream>

using namespace std;

int n, m;
int *row, *col;

int main() {

	cin >> n;
	cin >> m;

	row = new int[n];
	for (int i = 0; i < n; i++) {
		row[i] = 0;
	}
	col = new int[m];
	for (int i = 0; i < m; i++) {
		col[i] = 0;
	}


	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			if (str[j] == 'X') {
				row[i]++;
				col[j]++;
			}
		}
	}

	// 모든 행과 모든 열에 한 명 이상의 경비원
	// 몇 명의 경비원을 최소로 추가해야 조건을 만족하는가

	int cnt = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (row[i] == 0 && col[j] == 0) {
				cnt++;
				row[i]++;
				col[j]++;
			}
		}
	}

	for (int i = 0; i < n; i++) {
		if (row[i] == 0) {
			row[i]++;
			cnt++;
		}
	}
	for (int j = 0; j < m; j++) {
		if (col[j] == 0) {
			col[j]++;
			cnt++;
		}
	}

	cout << cnt;

	return 0;
}