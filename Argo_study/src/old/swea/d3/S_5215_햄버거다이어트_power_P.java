package old.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * 

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

public class S_5215_햄버거다이어트_power_P {

	
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
			
			powerSet(0,new boolean[fact.length],fact);

			System.out.println("#"+t+" "+ans);
			
		}
		

	}

	private static void powerSet(int k, boolean[] sel, int[][] fact) {		//파워셋
		//파워재귀
		
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			//풀이 -> 선택된 재료들의 칼로리의 합이 L이하인 애들중에 맛이 가장 좋은것의 집합을 구한다
			
			int calsum=0, tassum=0;			
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					calsum+= fact[i][1];
					tassum+=fact[i][0];
				}
				
			}
			
			if(calsum <=L) {
				ans = Math.max(ans, tassum);
			}
			
			
			return;
		}
		
		
		sel[k]=true;				//선택 하는거 안하는거 순서대로
		powerSet(k+1,sel,fact);
		sel[k]=false;
		powerSet(k+1,sel,fact);
		
		
	}
}
