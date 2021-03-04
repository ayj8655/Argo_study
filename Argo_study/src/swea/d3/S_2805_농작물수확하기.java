package swea.d3;

import java.util.Scanner;


/*
1
5
14054
44250
02032
51204
52212

D3
 */
public class S_2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int sum = 0, range = 1;
			int N = sc.nextInt();
			int[][] a = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					a[i][j] = str.charAt(j) - '0';
				}
			}
			
			for(int i = 0; i < N/2; i++) {
				
				int p = N/2 - i;
				
				for(int j = 0; j < range; j++) {	//위아래 번갈아가면서 마름모로 계산
					sum += a[i][p+j];				//위 배열
					sum += a[N-1-i][p+j];			//아래 배열
				}
				
				range += 2;		//탐색 범위 2칸씩 증가
			}
			
			for(int i = 0; i < N; i++) sum += a[N/2][i];	//중앙 한줄 계산
			
			
			System.out.println("#" + t + " " +sum);
		}
	}
}
