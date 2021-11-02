package old.baekjoon.gold;

import java.io.*;
import java.util.*;

public class B_15683_감시 {

	static class Point {
		int y, x, type;

		public Point(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int N, M, Ans = Integer.MAX_VALUE;
	static int arr[][];

	static LinkedList<Point> list = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_15683.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5)
					list.add(new Point(i, j, arr[i][j]));	//cctv정보를 리스트에 저장
			}
		}

		dfs(0, arr);
		System.out.println(Ans);
	}

	public static void dfs(int k, int[][] temp) {
		
		int[][] arrcopy = new int[N][M];	//각각의 지도 저장용
		if (k == list.size()) {	//모든 cctv를 검사했으면?
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0)
						cnt++;	//사각지대
				}
			}

			Ans = Math.min(Ans, cnt);	//사각지대 업데이트
		}

		else {
			int type = list.get(k).type;
			int curY = list.get(k).y;
			int curX = list.get(k).x;
			switch (type) {
				case 1: {
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < N; j++)
							arrcopy[j] = Arrays.copyOf(temp[j], M);//배열 복사
						
						find(i, curY, curX, arrcopy);
						dfs(k + 1, arrcopy);
					}
					break;
				}
	
				case 2: {
					for (int i = 0; i < 2; i++) {
						for (int j = 0; j < N; j++)
							arrcopy[j] = Arrays.copyOf(temp[j], M);
						
						find(i, curY, curX, arrcopy);
						find(i + 2, curY, curX, arrcopy);
						dfs(k + 1, arrcopy);
					}
					break;
				}
	
				case 3: {
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < N; j++)
							arrcopy[j] = Arrays.copyOf(temp[j], M);
						
						find(i, curY, curX, arrcopy);
						find((i + 1) % 4, curY, curX, arrcopy);
						dfs(k + 1, arrcopy);
					}
					break;
				}
	
				case 4: {
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < N; j++)
							arrcopy[j] = Arrays.copyOf(temp[j], M);
						
						find(i, curY, curX, arrcopy);
						find((i + 1) % 4, curY, curX, arrcopy);
						find((i + 2) % 4, curY, curX, arrcopy);
						dfs(k + 1, arrcopy);
					}
					break;
				}
	
				case 5: {
					for (int i = 0; i < N; i++)
						arrcopy[i] = Arrays.copyOf(temp[i], M);
					
					find(0, curY, curX, arrcopy);
					find(1, curY, curX, arrcopy);
					find(2, curY, curX, arrcopy);
					find(3, curY, curX, arrcopy);
					dfs(k + 1, arrcopy);
	
					break;
				}

			}
		}
	}

	public static void find(int d, int y, int x, int[][] arrcopy) {
		int nx, ny;
		while (true) {

			nx = x + dx[d];
			ny = y + dy[d];

			if (!isPossble(ny, nx) || arrcopy[ny][nx] == 6)	//범위 또는 6일경우 
				break;
			if (arrcopy[ny][nx] >= 1 && arrcopy[ny][nx] <= 5) {	//cctv만날경우
				x = nx;
				y = ny;

				continue;
			}
			arrcopy[ny][nx] = 10;
			x = nx;
			y = ny;

		}
	}

	public static boolean isPossble(int dy, int dx) {
		return (dy >= 0 && dy < N) && (dx >= 0 && dx < M) ? true : false;
	}

}
