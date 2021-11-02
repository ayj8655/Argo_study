package old.professor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_14502_연구소_Pro {
	static int N,M,ans;
	static int[][] map, dfsMap, bfsMap;
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("연구소.txt"));
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		map=new int[N][M];
		dfsMap=new int[N][M];
		bfsMap=new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c]=input.nextInt();
			}
		}
		//print(map);
		// 모든 0 공간에 3개의 벽을 다 세운다
		// 바이러스 퍼트리고 
		// 안전영역 갯수를 셋다
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c]==0) {
					copyMap(map,dfsMap);
					dfsMap[r][c]=1;
					dfs(1);
					dfsMap[r][c]=0;
				}
			}
		}
		// bfs test
		//bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		copyMap(dfsMap, bfsMap);
		
		Queue<Loc> Q = new LinkedList<>();
		for (int r = 0; r < bfsMap.length; r++) {
			for (int c = 0; c < bfsMap[r].length; c++) {
				if(bfsMap[r][c]==2) {
					Q.add(new Loc(r,c));
				}
			}
		}
		//System.out.println(Q.size());
		while(!Q.isEmpty()) {
			Loc p = Q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&bfsMap[nr][nc]==0) {
					bfsMap[nr][nc]=2;
					Q.add(new Loc(nr,nc));
				}
			}
		}
		//print(bfsMap);
		// 안전영역 갯수 세기
		int cnt = 0;
		for (int i = 0; i < bfsMap.length; i++) {
			for (int j = 0; j < bfsMap[i].length; j++) {
				if(bfsMap[i][j]==0) {
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	
	static class Loc{
		int r, c;
		Loc(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	
	private static void dfs(int cnt) {
		if(cnt==3) {
//			print(dfsMap);
//			System.out.println("----------------------------");
			// 바이러스 퍼트리기
			bfs();
			return;
		}
		for (int r = 0; r < dfsMap.length; r++) {
			for (int c = 0; c < dfsMap[r].length; c++) {
				if(dfsMap[r][c]==0) {
					dfsMap[r][c]=1;
					dfs(cnt+1);
					dfsMap[r][c]=0;
				}
			}
		}
		
	}


	private static void copyMap(int[][] ori, int[][] target) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				target[r][c]=ori[r][c];
			}
		}
		
	}
	private static void print(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}