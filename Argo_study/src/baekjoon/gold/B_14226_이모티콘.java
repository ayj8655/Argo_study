package baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_14226_이모티콘 {

	static class Point {
		int len;
		int buf;
		int cnt;

		Point(int len, int buf, int cnt) {
			this.len = len;
			this.buf = buf;
			this.cnt = cnt;
		}
	}

	static int S;
	static boolean[][] visited = new boolean[2002][2002];

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		S = sc.nextInt();

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 0, 0));
		visited[1][0] = true;

		while (!q.isEmpty()) {

			Point p = q.poll();

			if (p.len == S) {
				System.out.println(p.cnt);
				return;
			}

			q.add(new Point(p.len, p.len, p.cnt + 1));

			if (p.buf != 0 && !visited[p.len + p.buf][p.buf] && p.len + p.buf <= 1000) {
				q.add(new Point(p.len + p.buf, p.buf, p.cnt + 1));
				visited[p.len + p.buf][p.buf] = true;

			}

			if (1 <= p.len && !visited[p.len - 1][p.buf]) {
				q.add(new Point(p.len - 1, p.buf, p.cnt + 1));
				visited[p.len - 1][p.buf] = true;

			}
		}

	}

}
