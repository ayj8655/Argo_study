package baekjoon.bronze;

import java.util.Scanner;

//브론즈
//im기출

public class B_2669_직사각형네개의합집합의면적구하기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[][] = new int [101][101];
		
		int x,y,xx,yy;
		
		for (int t = 0; t < 4; t++) {
			x = sc.nextInt();
			y = sc.nextInt();
			xx = sc.nextInt();
			yy = sc.nextInt();
			
			for (int i = x; i < xx; i++) {
				for (int j = y; j < yy; j++) {
					arr[i][j] = 1;
				}
			}	
		}
		
		int cnt[] = new int[2];
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				cnt[arr[i][j]]++;
			}
		}
		
		System.out.println(cnt[1]);
		
	}
}
