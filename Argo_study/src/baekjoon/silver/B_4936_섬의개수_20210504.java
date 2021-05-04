package baekjoon.silver;

import java.io.*;
import java.util.*;

public class B_4936_섬의개수_20210504 {

	static int dx[] = { 1, -1, 0, 0, -1, -1, 1, 1, };
	static int dy[] = { 0, 0, -1, 1, 1, -1, 1, -1, };

	static int arr[][];
	static boolean v[][];

	static int N, M, Ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_4963.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		while (true) {
			Ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			arr = new int[N][M];
			v = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && !v[i][j]) {

						//dfs(i, j);
						bfs(i,j);
						Ans++;
					}

				}
			}

			sb.append(Ans + "\n");

		}

		System.out.print(sb.toString());

	}

	private static void bfs(int i, int j) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		
		v[i][j] = true;
		q.add(new int[] {i,j});
		
		while (!q.isEmpty()) {
			
			int p[] = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = p[0] + dx[d];
				int ny = p[1] + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && !v[nx][ny]) {
					v[nx][ny] = true;
					q.add(new int [] {nx,ny});
	
				}
			}
		}
	}

	private static void dfs(int i, int j) {

		v[i][j] = true;

		for (int d = 0; d < 8; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && !v[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
	
	
	
	
	
	

}
