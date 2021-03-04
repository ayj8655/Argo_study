package baekjoon.silver;

import java.util.Scanner;
//실버
public class B_2578_빙고_O {
	static int N,T,Ans;
	static int arr[][];
	
	static int[] dx = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		int s;
		int cnt=0;
		
		while (true) {
			s = sc.nextInt();
			cnt++;
			Ans=0;
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(arr[i][j]==s) arr[i][j]= 30;		
				}
			}
			
			
			
			int gcnt=0,scnt=0,dcnt=0;
			//가로 한번 , 세로한번 대각선 한번
			for (int i = 0; i < 5; i++) {
				gcnt=0;
				if(arr[i][0] == 30) {
					
					for (int j = 0; j < 5; j++) {
						if (arr[i][j]== 30) gcnt++;
					}
					
					if(gcnt==5) Ans++;
					
				}
			}
			//세로
			for (int i = 0; i < 5; i++) {
				scnt=0;
				if(arr[0][i] == 30) {
					
					for (int j = 0; j < 5; j++) {
						if (arr[j][i]== 30) scnt++;
					}
					if(scnt==5) Ans++;
					
				}
			}
			
			dcnt=0;
			if(arr[0][0] == 30) {
				
				for (int j = 0; j < 5; j++) {
					if (arr[j][j]== 30) dcnt++;
				}
				if(dcnt==5) Ans++;
				
			}
			dcnt=0;
			if (arr[4][0]==30) {
				int ab=4;
				for (int j = 0; j < 5; j++) {
					if (arr[ab][j]== 30) dcnt++;
					ab--;
				}
				if(dcnt==5) Ans++;
				
			}
				
			
			if(Ans>=3) {
		//		print();
				System.out.println(cnt);
				break;
			}
			
		}
		
		
		
	}
	private static void print() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
