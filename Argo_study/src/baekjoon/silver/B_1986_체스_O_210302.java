package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B_1986_체스_O_210302 {
	
	static int N, M;
	
	static int Q, K, P;
	
	static int [][] arr;
	
	static int [] ans = new int [8];
	
	static int dx[] = {1,-1,0,0,1,1,-1,-1};
	static int dy[] = {0,0,-1,1,1,-1,1,-1};
	
	static int ddx[] = {-2,-1,1,2,2,1,-1,-2};
	static int ddy[] = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int [N][M];
		
		Q = sc.nextInt(); // 퀸의 개수
		for (int i = 0; i < Q; i++) {
			arr[sc.nextInt()-1][sc.nextInt()-1] = 1;
		}
		K = sc.nextInt(); // 킹의 개수
		for (int i = 0; i < K; i++) {
			arr[sc.nextInt()-1][sc.nextInt()-1] = 2;
		}
		P = sc.nextInt(); // 폰의 개수
		for (int i = 0; i < P; i++) {
			arr[sc.nextInt()-1][sc.nextInt()-1] = 3;
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}System.out.println();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if(arr[i][j] == 1) {
					
					for (int d = 0; d < 8; d++) {
						
						int nx = i+dx[d];
						int ny = j+dy[d];
						while (nx >=0 && ny >=0 && nx<N && ny <M) {
							if(arr[nx][ny] == 0 || arr[nx][ny] ==4) {
								arr[nx][ny] = 4;
								nx+=dx[d];
								ny+=dy[d];
							}else break;		
						}						
					}				
				}
				else if(arr[i][j] == 2) {
					
					for (int d = 0; d < 8; d++) {
						
						int nx = i+ddx[d];
						int ny = j+ddy[d];
						
						if(nx >=0 && ny >=0 && nx<N && ny <M) {
							if(arr[nx][ny]==0) arr[nx][ny] = 4;
						}
						
					}
				}	
			}
		}
		
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans[arr[i][j]]++;
			}
		}
		System.out.println(ans[0]);		//숫자가 0인거 출력하면됨
		
		
		
		
	}
}
