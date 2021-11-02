package old.professor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 배열돌리기4_pro {
	static int N, M, K,L,ans=Integer.MAX_VALUE;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] com;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("배열돌리기4.txt"));
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		L = s.nextInt();
		map = new int[N+1][M+1];
		for (int r = 1; r < N+1; r++) {		//인풋
			for (int c = 1; c < M+1; c++) {
				map[r][c] = s.nextInt();
			}
		}
		com = new int[L][];
		
		for (int l = 0; l < L; l++) {	
			com[l] = new int[] {s.nextInt(),s.nextInt(),s.nextInt()};
		}
		// 순열구하기
		permutation(0, new int[L], new boolean[L]);
		
		System.out.println(ans);
	}
	
	private static void permutation(int idx, int[] sel, boolean[] v) {
		if(idx==L) {
			//System.out.println(Arrays.toString(sel));
			int value = solve(sel);
			ans = Math.min(ans, value);
			return;
		}
		for (int i = 0; i < L; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[idx]=i;
				permutation(idx+1, sel, v);
				v[i]=false;
			}
		}
	}

	private static int solve(int[] sel) {
		// 배열복사
		int[][] tmap = new int[map.length][map[0].length];
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap[i].length; j++) {
				tmap[i][j]=map[i][j];
			}
		}
		// 순열 수만큼 돌려라
		for (int i = 0; i < sel.length; i++) {
			//System.out.println(Arrays.toString(com[sel[i]]));
			// 기준값 정하기
			// (r-s, c-s) -> (r-s, c+s)
			int osr = com[sel[i]][0]-com[sel[i]][2];
			int osc = com[sel[i]][1]-com[sel[i]][2];
			int oer = com[sel[i]][0]+com[sel[i]][2];
			int oec = com[sel[i]][1]+com[sel[i]][2];
			
			// 몇단계 돌려야 하는지
			int step = Math.min(Math.abs(oer-osr)/2,Math.abs(oec-osc)/2);
			
			// 단계수 만큼 돌리기
			for (int d = 0; d < step; d++) {
				
				int sr = osr + d;
				int sc = osc + d;
				int er = oer - d;
				int ec = oec - d;
				
				int dir=0;
				int tmp = tmap[osr+d][osc+d];
				// 4방향으로 줄줄 타고가기
				while(dir<4) {
					int nr = sr+dr[dir];
					int nc = sc+dc[dir];

					if(nr>=osr+d && nr<=oer-d && nc>=osc+d && nc<=oec-d) {
						tmap[sr][sc]=tmap[nr][nc];
						sr=nr;
						sc=nc;
					}else {
						dir++;
					}
				}
				// 처음거 넣기
				tmap[osr+d][osc+d+1]=tmp;
			}
			
			
		}
		//print(tmap);
		// 최소값구하기
		int res = Integer.MAX_VALUE;
		for (int r = 1; r < tmap.length; r++) {
			int sum=0;
			for (int c = 1; c < tmap[r].length; c++) {
				sum+=tmap[r][c];
			}
			res = Math.min(res, sum);
		}
		
		return res;
	}

	private static void print(int[][] map) {
		for (int r = 1; r < map.length; r++) {
			for (int c = 1; c < map[r].length; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		
	}
	
}
