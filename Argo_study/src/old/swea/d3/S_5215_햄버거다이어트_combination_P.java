package old.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

/*

1
5 1000
100 200
300 500
250 300
500 1000
400 400 

#1 750
 * 
 * 
 * 
 * */
public class S_5215_햄버거다이어트_combination_P {

	static int T,N,L;
	static int ans=0,max=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			ans=0;
			//재료 정보를 받는다.
			
			int[][] fact = new int[N][2];
			
			for (int i = 0; i < fact.length; i++) {
				//0에는 맛 1에는 칼로리
				fact[i][0] = sc.nextInt();
				fact[i][1]=sc.nextInt();
			}
			//리스트를 쓰면 안된다. 
			//칼로리와 맛의 점수를 변수로 가져가라
			combination(fact,0,0,0);
			

			
			
			
			System.out.println("#"+t+" "+ans);
			
		}
		

	}

	private static void combination(int[][] fact, int idx, int csum, int tsum) {//원본배열,idx,k,칼로리점수,맛점수
		
		
		
//		csum+=fact[idx][1];
//		tsum+=fact[idx][0];
		combination(fact, idx+1,csum+fact[idx][1] , tsum+fact[idx][0]);
		
		combination(fact, idx+1, csum, tsum);
		
		
		
	}

}
