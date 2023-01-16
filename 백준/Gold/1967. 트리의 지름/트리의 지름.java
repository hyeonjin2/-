import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static class Node {
    int vertex, weight;
    Node next;

    public Node(int vertex, int weight, Node next) {
      this.vertex = vertex;
      this.weight = weight;
      this.next = next;
    }
  }

  static int max;
  static int[] weight;

  static boolean[] visited;
  static Node[] adjList;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    adjList = new Node[n + 1];

    // 그래프 인접리스트 구성하기
    StringTokenizer st;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      adjList[from] = new Node(to, weight, adjList[from]);
      adjList[to] = new Node(from, weight, adjList[to]);
    }
    // 노드 별로 최대 길이 구하기 -> DFS
    int ans = 0;
    weight = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      max = 0;
      visited = new boolean[n + 1];
      dfs(i, 0);
      weight[i] = max;
      ans = Math.max(ans, weight[i]);
    }
    System.out.println(ans);
  }

  private static void dfs(int cur, int length) {
    visited[cur] = true;
    max = Math.max(max, length);
    for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
      if (!visited[temp.vertex]) {
        dfs(temp.vertex, length + temp.weight);
      }
    }
  }
}