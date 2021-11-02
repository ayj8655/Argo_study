package old.baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
단지 번호 붙이기 DFS

7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9


 * 
 * 
 */
public class B_2667_단지번호붙이기 {

	
	static int[][] arr;
	static int N,cnt;
	static int[][] v;
	static int[] dx = {-1,1,0 ,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N][N];
		v = new int [N][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 1 && v[i][j] == 0) {
					cnt=1;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		
		Collections.sort(list);
		System.out.println(list.size());
        for(int i=0;i<list.size();i++)	System.out.println(list.get(i));
	
		
	}

	private static void dfs(int i, int j) {
		v[i][j] = 1;
		
		for (int d = 0; d < 4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			
			if ( nx>=0 && ny >= 0 && nx < N && ny <N) {
				if(arr[nx][ny] == 1 && v[nx][ny] ==0) {
					dfs(nx,ny);
					cnt++;
				}
				
			}
		}
	}

}
