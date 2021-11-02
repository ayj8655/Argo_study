package old.baekjoon.silver;

import java.util.Scanner;

//달팽이 배열 문제

public class B_10157_자리배정 {
	static int C,R,K,cnt=1;
	static int dx[] = {-1,0,1,0}; // 상 , 우 , 하 , 좌
	static int dy[] = {0,1,0,-1};
	static boolean v[][];
	static int arr[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[R][C];
		
		if(C*R <K) {
			System.out.println(0);
			System.exit(0);
		}
		
		int x = R-1, y=0,d=0;
		while (cnt!=K) {
			arr[x][y] = cnt;
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || ny < 0 || nx>=R || ny>=C || arr[nx][ny]!=0) {
				d++;
				if(d==4) d=0;
				nx = x+dx[d];
				ny = y+dy[d];
			}
			x=nx;
			y=ny;
			cnt++;
		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		System.out.printf("%d %d",y+1,R-x);
		
	}
		
}
