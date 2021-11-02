package old.swea.d3;

import java.util.Arrays;
import java.util.Scanner;


/*
9229. 한빈이와 Spot Mart
d3
 * 
 * 
 * 
 * */
public class S_9229_한빈이와SpotMart {
	static int T,N,M,Ans;
	static boolean flag =true;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			Ans=0;
			flag = true;
			int[] arr = new int [N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			combination(arr,new int[2],0,0);
			
			if(Ans!=0) System.out.printf("#%d %d\n", t,Ans);
			else System.out.printf("#%d -1\n",t);
			
		}
		

	}

	private static void combination(int[] arr, int[] sel, int k, int idx) {
		if(k==sel.length) {
			int sum=0;
			
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			
			if(sum<=M) Ans = Math.max(Ans, sum);
			return;
		}
		
		
		for (int i = idx; i < arr.length; i++) {
			//(arr[i]> M) return;	//M보다 크면 아예 패스
			//else if (sel[k]+arr[i]>M) return;	//두개 합해서 M보다 커도 패스
			
			sel[k]=arr[i];
			combination(arr, sel, k+1, i+1);
		}
		
	}

}
