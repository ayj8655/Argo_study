package old.baekjoon.gold;

import java.util.LinkedList;
import java.util.Scanner;
/*
조합
골드 5

 * 
 * 
 */
public class B_15686_치킨배달 {

	static class Point {
		public int x, y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	
	static int N,M,Ans = Integer.MAX_VALUE;
	static int [][] arr;
	static LinkedList<Point> home,chicken;
	static Point [] sel;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int [N][N];
		home = new LinkedList<>();
		chicken = new LinkedList<>();
		sel = new Point[M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int  temp = sc.nextInt();
				if(temp == 1) home.add(new Point(i,j));
				if(temp == 2) chicken.add(new Point(i,j));
			}
		}
		
		combi(0,0);
//		combi_bit(0,0,0);
		
		System.out.println(Ans);
	}


	
	private static void combi(int idx, int k) {
		if (k == M) {
			int dis = 0;
			for (int h = 0; h < home.size(); h++) {
				int dist = Integer.MAX_VALUE;
				for (int s = 0; s < M; s++) {
					int res = Math.abs(home.get(h).x - sel[s].x);
					res += Math.abs(home.get(h).y - sel[s].y);
					dist = Math.min(dist, res);
				}
				dis += dist;
			}
			Ans = Math.min(Ans, dis);
			return;
		}
		if(idx == chicken.size()) return;
		sel[k] = chicken.get(idx);
		combi(idx+1, k+1);
		combi(idx+1, k);
		
	}
	

	
	
	private static void combi_bit(int bit, int k,int idx) {
		if (k == M) {
			int dis = 0;
			
			for (int h = 0; h < home.size(); h++) {
				int dist = Integer.MAX_VALUE;
				for (int s = 0; s < M; s++) {
					int res = Math.abs(home.get(h).x - sel[s].x);
					res += Math.abs(home.get(h).y - sel[s].y);
					dist = Math.min(dist, res);
				}
				dis += dist;
			}
			Ans = Math.min(Ans, dis);
			return;
		}
		
		if(idx == chicken.size()) return;
		
		for (int i = 0; i < chicken.size(); i++) {
			if((bit&1<<i)!=0) continue;
			bit = (bit|1<<i);
			sel[k] = chicken.get(i);
			combi_bit(bit,k+1, idx+1);
		}
	}
}
