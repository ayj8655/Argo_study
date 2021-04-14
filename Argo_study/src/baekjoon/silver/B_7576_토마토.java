package baekjoon.silver;

import java.io.*;
import java.util.*;

//BFS로 좋은 문제
public class B_7576_토마토 {

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int N, M,Ans;
	static int arr[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		LinkedList<int[]> q = new LinkedList<int[]>();
		boolean v[][] = new boolean[N][M];
		boolean flag = true;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					int tem[] = new int [3];
					tem[0] = i;	tem[1] = j;	tem[2] = 0;
					
					q.add(tem);
					v[i][j] = true;
					
				}
			}
		}

		
		while (!q.isEmpty()) {
			int p[] = new int [3];
			p = q.poll();
			int cnt = Ans = p[2];
//			System.out.println(cnt);
			for (int d = 0; d < 4; d++) {
				int nx = p[0]+dx[d];
				int ny = p[1]+dy[d];
				
				if(nx <0 || ny < 0 || nx >=N || ny >= M ) continue;
				
				if(arr[nx][ny] == 0 && !v[nx][ny]) {
					arr[nx][ny] = 1;
					q.add(new int[] {nx,ny,cnt+1});
					v[nx][ny] = true;
				}
			}
			
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					flag = false;
					break;
				}
			}
		}
		
		
		if(flag)
			System.out.println(Ans);
		else {
			System.out.println(-1);
		}
		
		
//		print();

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
