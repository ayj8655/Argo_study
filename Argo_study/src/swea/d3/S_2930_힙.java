package swea.d3;

import java.util.*;

import java.io.*;

public class S_2930_힙 {

	static class Point implements Comparable<Point> {
		int x;

		public Point(int x) {
			super();
			this.x = x;
		}

		@Override
		public int compareTo(Point o) {
			// TODO 자동 생성된 메소드 스텁
			return o.x - this.x;
		}

		@Override
		public String toString() {
			return "" + x + "";
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {

			sb.append("#" + t + " ");

			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Point> q = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				if (Integer.parseInt(st.nextToken()) == 1) {
					q.add(new Point(Integer.parseInt(st.nextToken())));

				} else {
					if(q.isEmpty()) {
						sb.append(-1 + " ");
					}else {
						sb.append(q.poll() + " ");	
					}
					

				}

			}
			sb.append("\n");

		}

		System.out.print(sb.toString());
	}

}
