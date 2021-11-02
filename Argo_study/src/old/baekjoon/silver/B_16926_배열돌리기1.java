package old.baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/16926
 * 배열 돌리기 1
 * 

입력

4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16 

출력 

3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14


 * 
 * 
 * 
 * 
 * 
 * 
 * */

public class B_16926_배열돌리기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dx = { 0, 1, 0, -1 };
	    int[] dy = { 1, 0, -1, 0 };
	    
		
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();		//회전수
 
        int[][] arr = new int[N][M];		//배열의 크기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
 
        int s = Math.min(N, M) / 2;	//돌릴개수
        
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < s; j++) {
			int d =0; //d는 방향
			int ox=j, oy=j;
			int tmp = arr[ox][oy];
			
			while (d<4) {
				int nx = ox + dx[d];
				int ny = oy + dy[d];
				
				if (nx >= j && ny >= j && nx < N - j && ny < M - j) {
					arr[ox][oy] = arr[nx][ny];
					ox = nx;
					oy = ny;
				} else d++;
				
			}
			arr[j+1][j] = tmp;
		}	
	}
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
	}
}
