package baekjoon.silver;

import java.util.*;
import java.io.*;

public class B_1012_유기농배추 {

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static int T, N, M, K;
	static int arr[][];
	static boolean v[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N][M];
			v = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[b][a] = -1;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == -1 && !v[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}

			sb.append(cnt + "\n");

		}
		System.out.println(sb.toString());

	}

	private static void dfs(int i, int j) {

		v[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == -1 && !v[nx][ny]) {
				dfs(nx, ny);
			}

		}

	}

}
