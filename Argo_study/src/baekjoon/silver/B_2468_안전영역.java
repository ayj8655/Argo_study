package baekjoon.silver;

import java.util.*;
import java.io.*;

public class B_2468_안전영역 {

	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	//Ans값을 1로 지정해서 통과
	
	static int N,Ans=1;
	static int arr[][];
	static int Mi = Integer.MAX_VALUE,Ma = Integer.MIN_VALUE;
	static boolean v [][];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_2468.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		v = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				Mi = Math.min(arr[i][j], Mi);
				Ma = Math.max(arr[i][j], Ma);
			}
		}
		
		
		for (int k = Mi; k <= Ma; k++) {
			v = new boolean [N][N];
			int cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] > k && !v[i][j]) {
						bfs(i,j,k);
						cnt++;
					}
				}
			}
			
			Ans = Math.max(Ans, cnt);
		}
		

//		print();
		System.out.println(Ans);
		
		
	}

	private static void bfs(int i, int j,int k) {
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		v[i][j] = true;
		q.offer(new int[] {i,j});
		
		while (!q.isEmpty()) {
			int [] tem = q.poll();
			int x = tem[0];
			int y = tem[1];
			
			for (int d = 0; d < 4 ; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(0<=nx && nx<N && 0<= ny && ny<N && !v[nx][ny] && arr[nx][ny] > k) {
					v[nx][ny]= true;
					q.offer(new int[] {nx,ny});
					
				}
				
			}
			
		}
		
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println(Mi + " " + Ma);
		
	}

}
