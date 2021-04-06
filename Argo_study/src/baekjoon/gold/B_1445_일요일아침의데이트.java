package baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_1445_일요일아침의데이트_X {

	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static int N,M;
	static int arr[][];
	static char map[][];
	static int cost[][];
	static int X,Y;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_1445.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		
		arr = new int [N][M];
		map = new char [N][M];
		cost = new int [N][M];

		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				
				cost[i][j] = Integer.MAX_VALUE;
				map[i][j] = c;
				if(c=='S') {
					X = i;
					Y = j;
					cost[i][j] = 0;
					
				}else if(c=='g') {
					arr[i][j] = 5000;
					for (int d = 0; d < 4; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx >=0 && ny >= 0 && nx< N && ny < M && arr[nx][ny]==0) 
							arr[nx][ny] =1;
					}
				}
			}
		}
		
	
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j]+" ");
//			} 
//			System.out.println();
//		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(cost[i][j]+" ");
			} 
			System.out.println();
		}


		dijkstra();
		
	}


	private static void dijkstra() {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {X,Y,0});
		
		while (!q.isEmpty()) {
			int p[] = q.poll();
			int x = p[0];
			int y = p[1];
			int co = p[2];
			
			if(map[x][y] == 'F') {
				System.out.println((cost[x][y]/5000) + " "+ cost[x][y]%5000);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
		
				int ncost = co + arr[nx][ny];
				if (cost[nx][ny] > ncost) {
	                cost[nx][ny] = ncost;
	                q.add(new int[] {nx,ny,ncost});
	            }

			}	
		}	
	}
}
