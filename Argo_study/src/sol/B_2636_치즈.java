package sol;

import java.util.*;
import java.io.*;


public class B_2636_치즈 {

	static int N,M;
	static int arr[][];
	static int cnt,realcnt,Ans;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_2636.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		while (true) {
			
			find();
			
			if(cnt==0) break;
			
			bfs();
			
			realcnt = cnt;
			
			Ans++;

		}
		
		sb.append(Ans).append("\n").append(realcnt);
		System.out.println(sb.toString());
		
		
		
	}


	private static void find() {
		cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 1) cnt++;
			}
		}
	}


	private static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean v[][] = new boolean [N][M];
		
		q.offer(new int[] {0,0});
		v[0][0] = true;
		
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx<0 || ny < 0 || nx>=N || ny >=M || v[nx][ny]) continue;
				
				if(arr[nx][ny] == 1) arr[nx][ny]=0;
				else q.offer(new int[] {nx,ny});
				
				v[nx][ny] = true;
				
				
			}
			
		}
		
		
	}

}
