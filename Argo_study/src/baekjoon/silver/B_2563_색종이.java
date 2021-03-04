package baekjoon.silver;

import java.util.Scanner;

/*
 * 백준 색종이
 * 
 */
public class B_2563_색종이 {
	static int N,Ans=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int [][] arr = new int[100][100];
		
		for (int i = 0; i < N; i++) {
			
			int nx = sc.nextInt();
			int ny = sc.nextInt();
			
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					
					if(arr[x+nx][y+ny]==1) continue;
					arr[x+nx][y+ny] =1;
					Ans++;
				}
			}
			
		}
		
		System.out.println(Ans);

	}

}
