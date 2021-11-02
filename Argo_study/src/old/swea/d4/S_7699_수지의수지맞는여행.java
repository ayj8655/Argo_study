package old.swea.d4;

import java.util.*;
import java.io.*;

public class S_7699_수지의수지맞는여행 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	static int N, M, cnt;
	static int[][] arr;
	static boolean[] visit = new boolean[26]; // 대문자 A : 65 --> 0 으로 Z : 90 --> 25
	
	static int Ans = 0;

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N][M];
			visit = new boolean[26];
			Ans = 0;
			
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int h = 0; h < M; h++) {
					arr[i][h] = str.charAt(h);
				}
			}

			visit[arr[0][0] - 65] = true; // 0,0 방문
			dfs(0, 0, 1);

			
			sb.append("#").append(tc).append(" ").append(Ans+"\n");
		}
		System.out.print(sb.toString());

	}
	
	
	static void dfs(int r, int c, int cnt) {

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;

			
			if (!visit[arr[nr][nc] - 65]) {			// 만약 방문한적 없는 곳이라면
				
				visit[arr[nr][nc] - 65] = true;		// 방문처리
				dfs(nr, nc, cnt + 1); 				// 이동
				visit[arr[nr][nc] - 65] = false;	// 되돌리기
			}
		}
		Ans = Math.max(cnt, Ans);	
	}
}
