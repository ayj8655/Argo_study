package swea.d4;

import java.util.*;
import java.io.*;


public class S_1249_보급로 {
	
	static class Point{
		int x;		int y;


		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int N;
	static int arr [][];
	static int v[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
	
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			v = new int [N][N];
			for(int i = 0; i < N; i ++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {	
					arr[i][j] = str.charAt(j) - '0';
					v[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(0,0);
			
			
			sb.append("#").append(t).append(" ").append(v[N-1][N-1]).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

	
	
	static void bfs(int i, int j) {
		LinkedList<Point> q = new LinkedList<>();
		
		q.add(new Point(0, 0));
		
		v[0][0] = arr[0][0];
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int x = p.x;
			int y = p.y;
			
			
			for(int d = 0 ; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if ((v[nx][ny] > v[p.x][p.y] + arr[nx][ny])) {
                    v[nx][ny] = v[p.x][p.y] + arr[nx][ny];
                    q.add(new Point(nx, ny));
                }
			}

		}
		
	}
	
}

