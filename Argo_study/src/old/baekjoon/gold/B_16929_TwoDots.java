package old.baekjoon.gold;

import java.io.*;
import java.util.*;

public class B_16929_TwoDots {

	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static int N,M;
	static char arr[][];
	static int dis[][];
	static boolean v[][];
	static boolean flag = false;
	
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("res/input_B_16929.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char [N][M];	//지도
		dis = new int [N][M];	//거리계산용
		v = new boolean[N][M];	//방문처리용
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}		
//		print();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j]) {
					dfs(i,j,arr[i][j],0);
				}
			}
		}
		
		if(flag) System.out.println("Yes");
		else System.out.println("No");
		
		

	}
	static void dfs(int i, int j, char ch, int cnt) {	//x, y, 문자, 카운트
		
		if(v[i][j]) {
			if(cnt - dis[i][j] >= 4) {
				flag = true;
				return;
			}
			else return;
		}

		v[i][j] = true;
		dis[i][j] = cnt;
		
		
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx >=0 && ny >=0 && nx<N && ny <M && arr[nx][ny] == ch) {//경계선안에있고 같은 문자면
				
				dfs(nx,ny,ch,cnt+1);			
			}
		}	
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
