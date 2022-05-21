#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	
	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int num, a;
	cin >> num;

	int dp0[41] = { 1,0, };
	int dp1[41] = { 0,1, };

	for (int k = 0; k < num; k++) {

		cin >> a;
		
		for (int i = 2; i <= a; i++) {

			dp0[i] = dp0[i - 1] + dp0[i - 2];
			dp1[i] = dp1[i - 1] + dp1[i - 2];

		}
		cout << dp0[a] << " " << dp1[a]<<endl;
	}

	return 0;
}