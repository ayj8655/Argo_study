package swea;

import java.util.*;
import java.io.*;


public class S_단식원 {

	static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M,Ans, T;
	static int [][] arr;
	static int [][] arrcopy;
	static int[] dx = { 1, -1, 0, 0 }; 
	static int[] dy = { 0, 0, -1, 1 };
	  
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Ans=0;
			arr = new int[N][M];
			
			for (int i = 0; i < N; i++) {	
				st = new StringTokenizer(br.readLine()," ");
						
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0);
			sb.append("#"+t+" "+Ans+"\n");
		}

		System.out.print(sb.toString());
		
		

	}
	private static void dfs(int i) {
		if(i == 3) {
			bfs();
			ansfind();
			return;
		}
		
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if(arr[j][k] == 0) {
					arr[j][k] =1;
					dfs(i+1);
					arr[j][k]=0;
				}
			}
		}
	}

	private static void ansfind() {
		int cnt =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arrcopy[i][j]==0) cnt++;
			}
		}
		Ans = Math.max(Ans, cnt);
		
	}
	private static void bfs() {
		arrcopy = new int[N][M];
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				arrcopy[i][j] = arr[i][j];
//			} 
//		}
		LinkedList<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, arrcopy[i], 0, arr[0].length);
			for (int j = 0; j < M; j++) {
				if(arrcopy[i][j]==2) q.add(new Point(i,j));
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if(arrcopy[i][j]==2) q.add(new Point(i,j));
//			}
//		}
		
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(arrcopy[nx][ny] == 0) {
                    	arrcopy[nx][ny] = 2;
                        q.add(new Point(nx, ny));
                    }
				}	
			}
		}
			
	}

}	
