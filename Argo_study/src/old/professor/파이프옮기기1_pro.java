package old.professor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 파이프옮기기1_pro {
	static int ans, N;
	static int[][] map;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("파이프옮기기1.txt"));
		Scanner sc = new Scanner(System.in);

		ans = 0;
		N = sc.nextInt();
		map = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// print(map);
		dfs(1, 2, 1);

		System.out.printf("%d\n", ans);

	}

	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 1, 0 };

	// 1 2 3 // 1 2 3
	private static void dfs(int r, int c, int d) {
		if (r == N && c == N) {
			//System.out.println("111111111");
			ans++;
			return;
		}
		
		if (d == 1) {
			for (int i = 1; i <= 2; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=1&&nr<=N&&nc>=1&&nc<=N&&check(r,c,i))
					dfs(nr,nc,i);
			}
		}else if(d==2) {
			for (int i = 1; i <= 3; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=1&&nr<=N&&nc>=1&&nc<=N&&check(r,c,i))
					dfs(nr,nc,i);
			}			
		}else if(d==3) {
			for (int i = 2; i <= 3; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=1&&nr<=N&&nc>=1&&nc<=N&&check(r,c,i))
					dfs(nr,nc,i);
			}			
		}
	}

	private static boolean check(int nr, int nc, int d) {
		
		if(d==1) {
			if(map[nr][nc+1]==0) return true;
		}else if(d==2) {
			if(map[nr][nc+1]==0&&map[nr+1][nc+1]==0&&map[nr+1][nc]==0)return true;
		}else if(d==3) {
			if(map[nr+1][nc]==0)return true;
		}
		return false;
	}

	private static void print(int[][] map) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
