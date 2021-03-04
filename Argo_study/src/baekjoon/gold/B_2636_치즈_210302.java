package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//골드
//bfs 0,0부터 사방 탐색해서 걸리는 1은 다 녹을수있다. 

public class B_2636_치즈_210302 {

	static int N,M,cnt,Ans,lastch;
	static int [][]arr;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [N][M];
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while (true) {
			find();
			if(cnt ==0) break;
			lastch = cnt;
			bfs();
			
			Ans++;		
		}
		
		
		System.out.println(Ans);
		System.out.println(lastch);
		
		
	}
	private static void find() {
		cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] ==1) cnt++;
			}
		}
		
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		v[0][0] = true;
		q.add(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny < 0 || nx >= N || ny >=M || v[nx][ny]) continue;
				
				if(arr[nx][ny] == 1) arr[nx][ny] = 0;
				else q.add(new Point(nx,ny));
				
				v[nx][ny] = true;
			}
			
			
		}
		
		
	}

}
