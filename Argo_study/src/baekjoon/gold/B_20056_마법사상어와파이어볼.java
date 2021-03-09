package baekjoon.gold;

import java.util.LinkedList;
import java.util.Scanner;

public class B_20056_마법사상어와파이어볼 {
	
	static class Point{
		int x,y,m,s,d;
		public Point(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N,M,K;
	static LinkedList<Point> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			q.add(new Point (sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt() ));
		}
		
		
		
	}
}
