#include<iostream>
using namespace std;

int main() {

	cin.tie(NULL);
	cout.sync_with_stdio(false);

	int num, a;
	cin >> num;

	int dp[11] = { 0, };

	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;

	for (int i = 4; i <= 11; i++) {
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	}

	for (int k = 0; k < num; k++) {
		cin >> a;
		cout << dp[a] << endl;
	}

	return 0;
}