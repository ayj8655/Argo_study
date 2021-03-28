package baekjoon;

import java.util.*;
import java.io.*;

public class DFS_BFS_기본코드 {
	
	static class Point {
		int x,y;
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	static int arr[][];
	static boolean[][] v;
	static int W,H;
	
	static int[] dx = {-1,1,0,0,1,1,-1,-1};
	static int[] dy = {0,0,-1,1,1,-1,1,-1};
	
	

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_4963.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W ==0 && H ==0) break;
			arr = new int [H][W];
			v = new boolean [H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					arr[i][j] =  Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt=0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(arr[i][j] ==1 && !v[i][j]) {
						dfs(i,j);
//						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

	private static void bfs(int i, int j) {
		LinkedList<Point> q = new LinkedList<>();
		//방문체크하고 큐에 넣기
		v[i][j] = true;
		q.add(new Point(i,j));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = p.y+dx[d];
				int ny = p.x+dy[d];
				
				if ( nx>=0 && ny >= 0 && nx < H && ny <W) {
					if(arr[nx][ny] == 1 && !v[nx][ny]) {
						v[nx][ny]=true;
						q.add(new Point(nx,ny));
					}
				}
			}
		}	
	}

	private static void dfs(int i, int j) {
		v[i][j] = true;
		
		for (int d = 0; d < 8; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			
			if ( nx>=0 && ny >= 0 && nx < H && ny <W) {
				if(arr[nx][ny] == 1 && v[nx][ny] ==false) {
					dfs(nx,ny);
				}
			}
		}
		
		
	}

}
