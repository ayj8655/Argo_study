package baekjoon.gold;

import java.util.LinkedList;
import java.util.Scanner;
/*
 * DFS와 BFS 혼합해서 사용
 * 완전탐색으로 출이
 * 
 * 
 * 
 * 
 */
public class B_14502_연구소 {

	static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M,Ans;
	static int [][] arr;
	static int [][] arrcopy;
	static int[] dx = { 1, -1, 0, 0 }; 
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {	//0 = 빈칸, 1 = 벽, 2는 바이러스
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		
		
		System.out.println(Ans);
		//print();
		
		
		

	}
	private static void dfs(int i) {
		if(i == 3) {
			//벽 다 만들었으니까 이제 퍼트려보기	
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
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arrcopy[i][j] = arr[i][j];
			} 
		}
		
		LinkedList<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arrcopy[i][j]==2) q.add(new Point(i,j));
			}
		}
		
		
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


	private static void print() {
		for (int i = 0; i < N; i++) {	//0 = 빈칸, 1 = 벽, 2는 바이러스
			for (int j = 0; j < M; j++) {
				System.out.print(arrcopy[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}	
