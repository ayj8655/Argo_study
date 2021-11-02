package old.baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_14938_서강그라운드 {

	static class Point implements Comparable<Point> {
		int num;
		int weight;

		public Point(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return weight - o.weight;
		}

	}

	static int N, M, R, Ans;
	static int dis[], arr[];
	static boolean v[];
	static LinkedList<LinkedList<Point>> list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_14938.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 지역의 개수
		M = Integer.parseInt(st.nextToken()); // 수색범위
		R = Integer.parseInt(st.nextToken()); // 길의 개수

		dis = new int[N + 1]; // 최단거리
		arr = new int[N + 1]; // 아이템 개수
		v = new boolean[N + 1]; // 방문체크

		list = new LinkedList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new LinkedList<>());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) { // 양방향
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Point(to, weight));
			list.get(to).add(new Point(from, weight));
		}

		for (int i = 1; i <= N; i++) {
			dijkstra(i);

			int sum = 0;
			for (int j = 1; j <= N; j++) {
				if (dis[j] <= M) {
					sum += arr[j];
				}
			}
			Ans = Math.max(Ans, sum);
		}

		System.out.println(Ans);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		Arrays.fill(dis, Integer.MAX_VALUE);
		Arrays.fill(v, false);

		dis[start] = 0;

		pq.offer(new Point(start, 0));
		while (!pq.isEmpty()) {
			int cur = pq.poll().num;

			if (v[cur])
				continue;
			v[cur] = true;

			for (Point node : list.get(cur)) {
				if (dis[node.num] > dis[cur] + node.weight) {
					dis[node.num] = dis[cur] + node.weight;

					pq.offer(new Point(node.num, dis[cur] + node.weight));
				}
			}
		}
	}

}
