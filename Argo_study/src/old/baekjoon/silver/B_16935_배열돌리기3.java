package old.baekjoon.silver;

import java.util.Scanner;

/*
 * 배열 돌리기 3
 * https://www.acmicpc.net/problem/16935
 * 
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1

 * 
 * 
 */
public class B_16935_배열돌리기3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		int[][] arr = new int[100][100];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		for (int k = 0; k < R; k++) {
		
		
		int A = sc.nextInt();
		switch (A) {
		case 1: {		//상하 반전
			int[][] tmp = new int[100][100];
			
			for (int i = 0; i < N; i++) {		
				for (int j = 0; j < M; j++) {	
					tmp[i][j] = arr[N-1-i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = tmp[i][j];
				}
			}
			
			break;
		}
		case 2: {		//좌우 반전
			int[][] tmp = new int[100][100];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmp[i][j] = arr[i][M-1-j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = tmp[i][j];
				}
			}
					
			break;
		}
		case 3: {		//오른쪽으로 90도
			int[][] tmp = new int[100][100];
			
			int H=N;
			int temp = N;
			N=M;
			M=temp;
			
			for (int i = 0; i < N; i++) {		//8
				for (int j = 0; j < M; j++) {	//6
					tmp[i][j] = arr[H - 1 - j][i];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = tmp[i][j];
				}
			}
			break;
		}
		case 4: {		//왼쪽으로 90도
			int[][] tmp = new int[100][100];
			
			int W=M;
			int temp = N;
			N=M;
			M=temp;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmp[i][j] = arr[j][W-1-i];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = tmp[i][j];
				}
			}
			
			break;
		}
		case 5: {		//5번 연산
			int[][] tmp = new int[100][100];
			
			int n = N/2, m = M/2;
			
			for(int i=0; i<n; i++)		//1번 -> 2번
				for (int j = 0; j < m; j++)
				{
					tmp[i][j+m] = arr[i][j];
				}
			for (int i = 0; i < n; i++)//2번 -> 3번
				for (int j = 0; j < m; j++)
				{
					tmp[i+n][j + m] = arr[i][j+m];
				}
			for (int i = 0; i < n; i++)//3번 -> 4번
				for (int j = 0; j < m; j++)
				{
					tmp[i+n][j] = arr[i+n][j+m];
				}
			for (int i = 0; i < n; i++)//4번 -> 1번
				for (int j = 0; j < m; j++)
				{
					tmp[i][j] = arr[i+n][j];
				}

			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					arr[i][j] = tmp[i][j];
			
			break;
		}
		case 6: {		//6번 연산
			int[][] tmp = new int[100][100];
			
			int n = N/2, m = M/2;
			
			for(int i = 0; i < n; i++)//4번 -> 3번
				for (int j = 0; j < m; j++)
				{
					tmp[i+n][j+m] = arr[i+n][j];
				}
			for (int i = 0; i < n; i++)//3번 -> 2번
				for (int j = 0; j < m; j++)
				{
					tmp[i][j + m] = arr[i+n][j+m];
				}
			for (int i = 0; i < n; i++)//2번 -> 1번
				for (int j = 0; j < m; j++)
				{
					tmp[i][j] = arr[i][j+m];
				}
			
			for (int i = 0; i < n; i++)//1번 -> 4번
				for (int j = 0; j < m; j++)
				{
					tmp[i+n][j] = arr[i][j];
				}
			

			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					arr[i][j] = tmp[i][j];
			break;
		}
				
		default:
			break;
	}
		
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
