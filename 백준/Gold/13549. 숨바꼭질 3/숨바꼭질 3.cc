#include<iostream>
#include<queue>
using namespace std;

// 숨바꼭질 3

void bfs(int start, int end);

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int start, end;

	cin >> start >> end;

	bfs(start, end);

	return 0;
}

void bfs(int start, int end) {
	queue<pair<int, int>> queue;
	bool visited[100001] = { false, };
	queue.push({start, 0});
	visited[start] = true;

	while (!queue.empty()) {
		pair<int, int> cur = queue.front();
		queue.pop();
		if (cur.first == end) {
			cout << cur.second;
			return;
		}
		if (cur.first != 0 && cur.first * 2 <= 100000 && !visited[cur.first * 2]) {
			queue.push({ cur.first * 2,cur.second });
			visited[cur.first * 2] = true;
		}
		if (cur.first - 1 >= 0 && !visited[cur.first - 1]) {
			queue.push({ cur.first - 1 ,cur.second + 1 });
			visited[cur.first - 1] = true;
		}
		if (cur.first + 1 <= 100000 && !visited[cur.first + 1]) {
			queue.push({ cur.first + 1 ,cur.second + 1 });
			visited[cur.first + 1] = true;
		}
	}

}