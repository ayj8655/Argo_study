package old.swea.d4;

import java.util.*;
import java.io.*;

public class S_5656_벽돌깨기 {
	
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	static int arr[][], tem[][];
	static int N, W, H,count;
	static int Ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			Ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			tem = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					tem[i][j] = arr[i][j];
				}
			}
			combi(new int[N], 0, 0);// 중복 조합
			
			sb.append("#").append(t).append(" ").append(Ans+"\n");

		}
		
		System.out.print(sb.toString());
	}

	private static void init() {// arr 초기화
		for (int i = 0; i < H; i++) {
			arr[i] = tem[i].clone();
		}
	}

	private static void combi(int[] sel, int k, int idx) {
		if (k == N) {
			init();
			count = 0;
			boom(sel);
			Ans = Math.min(Ans, count);
			return;
		}

		for (int i = 0; i < W; i++) {
			sel[k] = i;
			combi(sel, k + 1, i);
		}

	}

	private static void boom(int[] sel) {
		for (int i = 0; i < sel.length; i++) {
			for (int j = 0; j < H; j++) {
				if (arr[j][sel[i]] > 0) {

					int x = sel[i];
					int y = j;
					if (arr[y][x] == 1) {
						arr[y][x] = 0;
						break;
					}
					bfs(y, x);
					break;
				}
			}
			gravity();

		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] != 0) {
					count++;// 남은 벽돌 개수 카운트
				}
			}
		}

	}

	private static void gravity() {// 중력
		for (int j = 0; j < W; j++) {
			for (int i = H - 1; i >= 0; i--) {
				if (arr[i][j] != 0) {
					while (i + 1 < H && arr[i + 1][j] == 0) {
						arr[i + 1][j] = arr[i][j];
						arr[i][j] = 0;
						i++;
					}
				}

			}

		}
	}


	private static void bfs(int y, int x) {
		
		boolean v[][]= new boolean[H][W];

		LinkedList<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y));
		v[y][x] = true;

		while (!q.isEmpty()) {
			int x1 = q.peek().x;
			int y1 = q.peek().y;
			q.poll();
			int tmp = arr[y1][x1];
			tmp--;
			arr[y1][x1] = 0;
			for (int cnt = 1; cnt <= tmp; cnt++) {
				for (int d = 0; d < 4; d++) {
					int nx = x1 + dx[d] * cnt;
					int ny = y1 + dy[d] * cnt;
					if (nx >= 0 && nx < W && ny >= 0 && ny < H && !v[ny][nx]) {
						if (arr[ny][nx] == 1) {
							arr[ny][nx] = 0;
							v[ny][nx] = true;
						} else if (arr[ny][nx] > 1) {
							q.offer(new Point(nx, ny));
							v[ny][nx] = true;
						}
					}
				}
			}

		}
	}

}

