#include <iostream>
using namespace std;

int main() {

	int n, m;
	cin >> n >> m;

	char** map = new char* [n];
	for (int i = 0; i < n; i++) {
		map[i] = new char[m];
	}

	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			map[i][j] = str[j];
		}
	}

	// row 검사
	int row_cnt = n;
	for (int i = 0; i < n; i++) {
		bool flag = false;
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 'X')
				flag = true;
		}
		if (flag)
			row_cnt--;
	}

	// col 검사
	int col_cnt = m;
	for (int j = 0; j < m; j++) {
		bool flag = false;
		for (int i = 0; i < n; i++) {
			if (map[i][j] == 'X')
				flag = true;
		}
		if (flag)
			col_cnt--;
	}

	
	cout << max(row_cnt, col_cnt);


	for (int i = 0; i < n; i++) {
		delete map[i];
	}

	delete map;

	return 0;
}