#include<iostream>
#include<string>
using namespace std;

class Stack {
private:
	char arr[51];
	int s_bottom;
	int s_top;

public:
	Stack() {
		s_bottom = 0;
		s_top = 0;
		arr[0] = '-1';
	}
	~Stack() {
		s_bottom = 0;
		s_top = 0;
	}
	void push(char a) {
		s_top++;
		arr[s_top] = a;
	}
	void pop() {
		if (s_top != 0) {
			s_top--;
		}
	}
	char top() {
		return arr[s_top];
	}
	int size() {
		return s_top - s_bottom;
	}
};

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int num;
	string str;

	cin >> num;

	for (int i = 0; i < num; i++) {
		cin >> str;

		Stack stack;

		for (int j = 0; j < str.size(); j++) {
			if(stack.size()==0){
				stack.push(str[j]);
			}
			else {
				if (stack.top()=='('&& str[j]==')')
					stack.pop();
				else {
					stack.push(str[j]);
				}
			}
		}
		if (stack.size() == 0) {
			cout << "YES" << "\n";
		}
		else {
			cout << "NO" << "\n";
		}
	}

	return 0;
}