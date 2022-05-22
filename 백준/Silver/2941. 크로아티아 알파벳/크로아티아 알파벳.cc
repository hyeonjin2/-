#include<iostream>
#include<string>
using namespace std;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	string a;
	cin >> a;

	string al[8] = { "c=","c-","dz=","d-","lj","nj","s=","z=" };

	int count = a.size();

	for (int i = 0; i < a.size(); i++) {
		for (int j = 0; j < 8; j++) {
			if (a[i] == al[j][0]) {
				if (a[i + 1] == al[j][1]) {
					if (j==2) {
						if (a[i + 2] == al[2][2]) {
							count -= 2;
							i += 2;
						}
					}
					else {
						count--;
						i++;
					}
				}
			}
		}
	}

	cout << count << endl;

	return 0;
}