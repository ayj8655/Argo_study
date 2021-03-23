package baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_1520_내리막길 {

	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	static int N,M,Ans;
	static int arr[][];
	static int dp[][];
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_1520.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		dp = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		
//		dfs(0,0);
//		System.out.println(Ans);
	
		System.out.println(dfs_return(0,0));
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
	
	
	
	
	private static int dfs_return(int i, int j) {
		if(i == N -1 && j == M -1) return 1;
		if(dp[i][j] != -1)	return dp[i][j];	//메모이제이션
		
		dp[i][j] = 0;
		
		for (int d = 0; d < 4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			
			if(nx >= 0 && ny >=0 && nx <N && ny <M) {
				if(arr[i][j] > arr[nx][ny]) dp[i][j] += dfs_return(nx, ny);			
			}	
		}
		
		return dp[i][j];
		
	}




	static void dfs(int i, int j) {
		
		for (int d = 0; d < 4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			
			if(nx >= 0 && ny >=0 && nx <N && ny <M) {
				
				if(nx ==(N-1) && ny == (M-1)) {
					Ans++;
					return;
				}
				
				if(arr[i][j] > arr[nx][ny]) dfs(nx,ny);					
			}	
		}	
	}
}
