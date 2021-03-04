package baekjoon.bronze;

import java.util.Scanner;

/*
20210222

2
0 0 10 10
2 2 6 6

64
36

 */
public class B_10163_색종이 {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cnt=1;
		int x,y,w,h;
		
		int [][] arr = new int[101][101];
		for (int n = 0; n < N; n++) {	
			x= sc.nextInt();
			y= sc.nextInt();
			w= sc.nextInt();
			h= sc.nextInt();
			for (int i = x; i < x+w; i++) {
				for (int j = y; j < y+h; j++) {
					arr[i][j] = cnt;
				}
			}
			cnt++;
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
//		cnt=1;
//		
//		
//		for (int n = 0; n < N; n++) {	
//			int temp=0;
//			for (int i = 0; i < 101; i++) {
//				for (int j = 0; j < 101; j++) {
//					if(arr[i][j] == cnt) temp++;
//				}
//			}
//			System.out.println(temp);
//			cnt++;
//		}
		
		//아래가 더 효율적
		
		int[] cnt1 = new int[N+1];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				cnt1[arr[i][j]]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(cnt1[i]);
		}
		
		
		
		
		
		
	}

}
