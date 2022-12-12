#include<iostream>
#include<limits.h>
#include<queue>
#include<vector>
using namespace std;

// 최소비용 구하기
vector<pair<int, int>> adj[1001];
vector<int> D(1001, INT_MAX);
int V, M;

void dijkstra(int start, int end);

int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> V >> M;

	// 인접리스트 만들기

	for (int i = 0; i < M; i++)
	{
		int from, to, weight;
		cin >> from >> to >> weight;
		adj[from].push_back({ to, weight });
	}

	int start, end;
	cin >> start >> end;

	dijkstra(start, end);

	return 0;
}



void dijkstra(int start, int end) 
{
	vector<int> D(1001, INT_MAX);
	vector<bool> visited(1001, false);

	// 시작점 최솟값으로 만들기
	D[start] = 0;

	for (int i = 0; i < V; i++)
	{
		int minVertex = -1;
		int min = INT_MAX;

		for (int j = 1; j <= V; j++)
		{
			if (!visited[j] && min > D[j])
			{
				min = D[j];
				minVertex = j;
			}
		}
		// 방문 체크
		if (minVertex < 0)
		{
			continue;
		}
		visited[minVertex] = true;

		// 도착점에 도달했다면 끝내기
		if (minVertex == end)
		{
			cout << D[end];
			return;
		}

		for (int i = 0; i < adj[minVertex].size(); i++)
		{
			pair<int, int> temp = adj[minVertex][i];
			if (!visited[temp.first] && D[temp.first] > D[minVertex] + temp.second)
			{
				D[temp.first] = D[minVertex] + temp.second;
			}
		}
	}
}