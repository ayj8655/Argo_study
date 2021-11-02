package old.baekjoon.silver;

import java.io.*;
import java.util.*;

public class B_2178_미로탐색 {

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static int N, M;
	static int arr[][];
	static boolean v[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);

	}

	private static void bfs(int i, int j) {

		LinkedList<int[]> q = new LinkedList<int[]>();
		v[i][j] = true;
		q.add(new int[] { i, j, 1 });

		while (!q.isEmpty()) {
			int p[] = q.poll();

			int x = p[0];
			int y = p[1];
			int cnt = p[2];

			if (x == N - 1 && y == M - 1) {
				System.out.println(cnt);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !v[nx][ny] && arr[nx][ny] == 1) {
					v[nx][ny] = true;
					q.add(new int[] { nx, ny, cnt + 1 });

				}

			}

		}

	}

}
