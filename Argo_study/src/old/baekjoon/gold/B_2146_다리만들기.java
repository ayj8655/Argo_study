package old.baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
다리만들기
bfs

10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

골드 3

 */
public class B_2146_다리만들기 {
	static int N,Ans=Integer.MAX_VALUE;
	static int [][] arr;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		int cnt=2;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {	//섬의 번호를 지정한다.
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==1) {
					dfs(i,j,cnt++);
				}
			}
		}
		
		//print();
		
		
		
		//최소다리길이 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]>1) {
					int d = bfs(i,j);
					if(d!=-1) Ans = Math.min(Ans, d);
				}
			}
		}
		
		System.out.println(Ans);
		
		
	}
	static class Point{
		int x,y,d;
		public Point(int x, int y,int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	private static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList();
		
		q.add(new Point(x,y,0));
		
		boolean[][] v = new boolean[N][N];
		v[x][y] = true;
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if ( nx>=0 && ny >= 0 && nx < N && ny < N && !v[nx][ny] && arr[nx][ny]==0) {
					v[nx][ny] = true;
					q.add(new Point(nx,ny,p.d+1));
				}
				
				if ( nx>=0 && ny >= 0 && nx < N && ny < N && !v[nx][ny] && arr[nx][ny]!=0 && arr[nx][ny]!=arr[x][y]) {
					return p.d;
					
				}
			}
		}
		return -1;
	}
	

	private static void dfs(int x, int y, int cnt) {	//섬 번호 나누기
		arr[x][y] = cnt;
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if ( nx>=0 && ny >= 0 && nx < N && ny < N) {
				if(arr[nx][ny] == 1) {	
					dfs(nx,ny,cnt);
				}
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	

	
}
