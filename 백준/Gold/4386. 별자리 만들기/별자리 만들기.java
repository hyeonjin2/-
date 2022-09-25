import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 별자리 만들기
public class Main {

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double d) {
			this.from = from;
			this.to = to;
			this.weight = d;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) Math.round(this.weight - o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	}

	static class Point {
		double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double distance(Point p) {
			return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
		}
	}

	static int N, size;
	static Point[] points;
	static Edge[] edgeList;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		points = new Point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		size = N * (N - 1) / 2;
		edgeList = new Edge[size];
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				edgeList[index++] = new Edge(i, j, points[i].distance(points[j]));
			}
		}
		Arrays.sort(edgeList);

		make();
		double sum = 0;
		for (int i = 0; i < size; i++) {
			int from = edgeList[i].from;
			int to = edgeList[i].to;
			if (union(from, to)) {
				sum += edgeList[i].weight;
			}
		}
		System.out.println(String.format("%.2f", sum));
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[size];
		for (int i = 0; i < size; i++) {
			parents[i] = i;
		}
	}
}