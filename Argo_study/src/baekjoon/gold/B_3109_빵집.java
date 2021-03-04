package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
5 5
.xx..
..x..
.....
...x.
...x.

*/
public class B_3109_빵집 {
	
	static int R,C,Ans=0;
	static char [][] arr;
	
	static boolean [][] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visited = new boolean [R][C];
		
		for (int i = 0; i < R; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		
		makePipe();
		System.out.println(Ans);
		
		
		
		
	}

	private static void makePipe() {
		//윗행부터 시도
		for (int i = 0; i < R; i++) {
			dfs(i,0);
		}
	}
	
	static int[] dr = {-1,0,1};
	private static boolean dfs(int r, int c) {
		
		if(c==C-1) {
			Ans++;
			return true;	//파이프 놓기 성공
		}
		
		
		int nr,nc= c+1;
		for (int d = 0; d < 3; d++) {
			nr = r+dr[d];
			if(nr<0|| nr>=R || arr[nr][nc]=='x' || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			if(dfs(nr,nc)) return true;
			
//			visited[nr][nc] = false;		//실패했던 흔적 되돌리지 않음. 뒤의 선택지의 방향은 현재보다 유리하지 않은 상황
											//결국 같은 상황 되풀이 된다.
			
		}
		
		return false;
		
	}
	

}

