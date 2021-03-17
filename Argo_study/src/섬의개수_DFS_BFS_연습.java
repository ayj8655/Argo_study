

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
섬의 개수

BFS
DFS
8방 탐색

 * 
 * 
 */
public class 섬의개수_DFS_BFS_연습 {
	
	static class Point {
		int x,y;
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,1,0,0,1,1,-1,-1};
	static int[] dy = {0,0,-1,1,1,-1,1,-1};
	
	static int W,H,cnt;
	static int [][] arr;
	static boolean [][] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean end = true;
		
		while(end) {
			W = sc.nextInt();	//너비
			H = sc.nextInt();	//높이
			if(W ==0 && H ==0) break;

			cnt=0;
			arr = new int[H][W];
			v = new boolean[H][W];
	
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) arr[i][j] = sc.nextInt();
			}			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(arr[i][j]==1 && v[i][j] ==false) {
					//	dfs(i,j);
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		
		}
	}

	private static void bfs(int x,int y) {
		Queue<Point> q = new LinkedList();
		q.add(new Point(x,y));		
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = p.y+dx[d];
				int ny = p.x+dy[d];
				
				if ( nx>=0 && ny >= 0 && nx < H && ny <W) {
					if(arr[nx][ny] == 1 && v[nx][ny] == false) {
						q.add(new Point(nx,ny));
						v[nx][ny]=true;
					}
				}
			}	
		}
	}
	
	

	private static void dfs(int x,int y) {
		v[x][y] = true;
		
		for (int d = 0; d < 8; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if ( nx>=0 && ny >= 0 && nx < H && ny <W) {
				if(arr[nx][ny] == 1 && v[nx][ny] ==false) {
					dfs(nx,ny);
				}
			}
		}
	}
}
