package professor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_17144_미세먼지안녕_Pro {
	static int R, C, T;
	static int[][] map;
	static int[] air;
	static Queue<Dust> Q;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("미세먼지안녕.txt"));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		Q = new LinkedList<>();
		air = new int[2];
		int p = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				int val = sc.nextInt();
				if (val > 0) {
					Q.add(new Dust(i, j, val));
				}
				if (val == -1) {
					air[p++] = i;
				}
			}
		}
		for (int i = 0; i < T; i++) {

			spread();
			rotate();
		}

		int sum = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	private static void spread() {
		map = new int[R + 1][C + 1];
		map[air[0]][1] = -1;
		map[air[1]][1] = -1;

		while (!Q.isEmpty()) {
			Dust p = Q.poll();
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr > 0 && nr <= R && nc > 0 && nc <= C && !(nr == air[0] && nc == 1)
						&& !(nr == air[1] && nc == 1)) {
					map[nr][nc] += p.val / 5;
					cnt++;
				}
			}
			if (cnt > 0) {
				map[p.r][p.c] += p.val - (p.val / 5) * cnt;
			}
		}

	}

	static int[] drUp = { -1, 0, 1, 0 };
	static int[] dcUp = { 0, 1, 0, -1 };
	static int[] drDown = { 1, 0, -1, 0 };
	static int[] dcDown = { 0, 1, 0, -1 };

	private static void rotate() {
		rotateUp();
		rotateDown();
		// 먼지 초기화
		Q.clear();
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (map[r][c] > 0) {
					Q.add(new Dust(r, c, map[r][c]));
				}
			}
		}
	}

	private static void rotateDown() {
		int dir = 0;
		int Sr = air[1];
		int Sc = 1;
		while (dir < 4) {
			int nr = Sr + drDown[dir];
			int nc = Sc + dcDown[dir];
			if (nr > 0 && nr <= R && nc > 0 && nc <= C) {
				// System.out.println("1111 : "+nr+":"+nc+"="+map[nr][nc]);
				if (map[Sr][Sc] != -1 && map[nr][nc] != -1) {
					map[Sr][Sc] = map[nr][nc];
				}
				if (map[nr][nc] == -1) {
					map[Sr][Sc] = 0;
				}
			}
			if ((nr == air[1] && nc == 1) || (nr == air[1] && nc == C) || (nr == R && nc == C)
					|| (nr == R && nc == 1)) {
				// System.out.println("22222 : "+nr+":"+nc);
				// System.out.println("aaaaaa");
				dir++;
			}
			Sr = nr;
			Sc = nc;
		}

	}

	private static void rotateUp() {
		int dir = 0;
		int Sr = air[0];
		int Sc = 1;
		while (dir < 4) {
			int nr = Sr + drUp[dir];
			int nc = Sc + dcUp[dir];
			if (nr > 0 && nr <= R && nc > 0 && nc <= C) {

				if (map[Sr][Sc] != -1 && map[nr][nc] != -1) {
					map[Sr][Sc] = map[nr][nc];
				}
				if (map[nr][nc] == -1) {
					map[Sr][Sc] = 0;
				}
			}
			if ((nr == 1 && nc == 1) || (nr == 1 && nc == C) || (nr == air[0] && nc == C)
					|| (nr == air[0] && nc == 1)) {
				dir++;
			}
			Sr = nr;
			Sc = nc;
		}

	}

	static class Dust {
		int r, c, val;

		Dust(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

	}

	private static void print(int[][] map) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}