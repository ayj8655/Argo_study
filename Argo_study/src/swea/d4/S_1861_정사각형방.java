package swea.d4;

import java.util.Scanner;
/*
 * 정사각형 방
 * 
 * 
입력
2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2 

출력
#1 1 2
#2 3 3


 */
public class S_1861_정사각형방 {

	static int N,T,ans,startnum;
	static int[][] map;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	private static void move(int r, int c, int cnt,int start) {
		//기저파트는 없음 자동 종료
		
		//ans=Math.max(ans, cnt);		//밑에 말고 if로 cnt랑 start 자리 정해주는거 해보기
		
		if(cnt > ans) {
			ans = cnt;
			startnum = start;
		}
		if(cnt == ans) startnum = Math.min(startnum, start);
		
		ans = Math.max(ans, cnt);
		
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
			ans=0;
			startnum=0;
			N = sc.nextInt();
			
			map = new int[N+2][N+2];	//+2 +2 씩 하면 경계선 체크 안해도 됨
			
			for (int q = 1; q <= N; q++) {		//대신 1부터 넣고 N까지 넣어야함
				for (int w = 1; w <= N; w++) {
					map[q][w] = sc.nextInt();
				}
			}
			
			//모든방이 출발점이 될수 있으므로 2중 루프로 시작한다
			//이동하는 초기값은 1부터 시작한다.
			
			for (int q = 1; q <= N; q++) {		
				for (int w = 1; w <= N; w++) {
					//사방탐색하여 +1 많은 방으로 이동
					
					move(q,w,1,map[q][w]);	//뒤에 값은 출발점때문에
				}
			}
			System.out.printf("#%d %d %d\n", t,startnum, ans);
		}
	}
}
