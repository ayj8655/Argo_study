package old.swea.d4;

import java.util.*;
import java.io.*;

public class S_1868_파핑파핑지뢰찾기 {

	static int N, M, Ans;
	static int arr[][];
	static boolean v[][];
	static int dx[] = { 1, -1, 0, 0, -1, -1, 1, 1, };
	static int dy[] = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			Ans=0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			v = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					if (str.charAt(j) == '.')
						arr[i][j] = -1; // 지뢰없음
					else
						arr[i][j] = -5; // 지뢰있음

				}
			}

			//print();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (arr[i][j] == -1) {// 지뢰가 아니면

						boolean flag = true;
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];

							if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == -5) {
								flag = false;
								break;
							}

						}

						if (flag) {
							bfs(i, j);
							Ans++;
						}
							

					}
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (arr[i][j] == -1) {// 지뢰가 아니면

						boolean flag = true;
						int cnt=0;
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];

							if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == -5) {
								cnt++;
							}

						}

						if (cnt!=0) {
							arr[i][j] = cnt;
							Ans++;
						}
							

					}
				}
			}
			
			
			
			
			//print();
			sb.append("#"+t+" ").append(Ans+"\n");
			
		}
		System.out.print(sb.toString());

	}

	private static void bfs(int i, int j) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		v[i][j]=true;
		q.add(new int[]{i,j});
		arr[i][j] = 0;
		while (!q.isEmpty()) {
			int p[] = q.poll();
			
			int x = p[0];
			int y = p[1];
			
			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				
				int cnt=0;
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < N &&!v[nx][ny]) {
					
					for (int d2 = 0; d2 < 8; d2++) {
						int nx2 = nx + dx[d2];
						int ny2 = ny + dy[d2];

						if (nx2 >= 0 && ny2 >= 0 && nx2 < N && ny2 < N && arr[nx2][ny2] == -5) {
							cnt++;
							
							
						}

					}
					
					if(cnt!=0) 
						arr[nx][ny]= cnt;
					else {
						arr[nx][ny]=0;
						v[nx][ny] = true;
						q.add(new int[] {nx,ny});
					}
						
					
				}

			}
			
			
			
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
