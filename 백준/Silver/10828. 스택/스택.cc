#include<iostream>
#include<string>
using namespace std;

class Stack {
private:
	int s_bottom;
	int s_top;
	int arr[10001];

public:
	Stack () {
		s_bottom = 0;
		s_top = 0;
		arr[0] = -1;
	}
	~Stack() {
		s_bottom = 0;
		s_top = 0;
	}

	void push(int num) {
		s_top++;
		arr[s_top] = num;
	}
	void pop() {
		if (s_top == 0) {
			cout << arr[s_top] << "\n";
		}
		else {
			int temp = arr[s_top];
			s_top--;
			cout << temp << "\n";
		}
	}
	void size() {
		cout << s_top - s_bottom << "\n";
	}
	void empty() {
		if (s_top == s_bottom)
			cout << 1 << "\n";
		else
			cout << 0 << "\n";
	}
	void top() {
		cout << arr[s_top] << "\n";
	}
};

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, a;
	string str;
	Stack stack;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> str;
		if (str == "push") {
			cin >> a;
			stack.push(a);
		} 
		else if (str == "pop") {
			stack.pop();
		}
		else if (str == "size") {
			stack.size();
		}
		else if (str == "empty") {
			stack.empty();
		}
		else {
			stack.top();
		}
	}

	return 0;
}