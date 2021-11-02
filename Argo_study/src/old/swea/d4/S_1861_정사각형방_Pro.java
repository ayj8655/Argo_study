package old.swea.d4;

import java.util.Scanner;
/*
 * 정사각형 방
 * 
 * 
 */
public class S_1861_정사각형방_Pro {

	static int N,T,ansCnt,ansStart;
	static int[][] map;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static Ans ans;
	
	static class Ans implements Comparable<Ans>{
		int start;
		int cnt;
		public Ans(int start, int cnt) {
			super();
			this.start = start;
			this.cnt = cnt;
		}


		@Override
		public String toString() {
			return start + " "+ cnt;
		}


		@Override
		public int compareTo(Ans o) {
			if(this.cnt == o.cnt) {
				return this.start - o.start; //오름차순
			}
			return o.cnt - this.cnt;
		}
		
	}
	
	
	
	private static void move(int r, int c, int cnt,int start) {
		//기저파트는 없음 자동 종료
		
		//ans=Math.max(ans, cnt);		//밑에 말고 if로 cnt랑 start 자리 정해주는거 해보기
		Ans tmp = new Ans(start,cnt);
		if (ans.compareTo(tmp)>0) {
			ans=tmp;
		}
		
		for (int k = 0; k < dc.length; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(map[r][c] == map[nr][nc]-1) {
				move(nr,nc,cnt+1,start);
			}
		}
	}
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ansCnt=0;
			ansStart=0;
			N = sc.nextInt();
			
			map = new int[N+2][N+2];	//+2 +2 씩 하면 경계선 체크 안해도 됨
			
			for (int q = 1; q <= N; q++) {		//대신 1부터 넣고 N까지 넣어야함
				for (int w = 1; w <= N; w++) {
					map[q][w] = sc.nextInt();
				}
			}
			ans = new Ans(Integer.MAX_VALUE,0);	//아래에서 계산하기 싫어서 클래스만듦
			
			//모든방이 출발점이 될수 있으므로 2중 루프로 시작한다
			//이동하는 초기값은 1부터 시작한다.
			
			for (int q = 1; q <= N; q++) {		
				for (int w = 1; w <= N; w++) {
					//사방탐색하여 +1 많은 방으로 이동
					
					move(q,w,1,map[q][w]);	//뒤에 값은 출발점때문에
				}
			}
			System.out.printf("#%d %s\n", t,ans);
		}
	}
	

}
