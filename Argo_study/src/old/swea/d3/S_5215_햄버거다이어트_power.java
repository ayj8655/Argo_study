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

public class S_5215_햄버거다이어트_power {

	static public class Food{
		public int jum, cal;
		
		public Food(int jum, int cal) {
			super();
			this.jum = jum;
			this.cal = cal;
		}
		@Override
		public String toString() {
			return "Food [jum=" + jum + ", cal=" + cal + "]";
		}
	}
	
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
			
			Food[] arr = new Food[N];
			
			for (int q = 0; q < N; q++) {
				arr[q] = new Food(sc.nextInt(),sc.nextInt());
			}
			powerSet(0,0,new boolean[arr.length],arr);

			System.out.println("#"+t+" "+ans);
			
		}
		

	}

	private static void powerSet(int idx, int k, boolean[] sel,Food[] arr) {		//파워셋
		
		if(idx==arr.length) {
			int sum = 0;
			int calsum=0;
			for (int i = 0; i < arr.length; i++) {
				if(sel[i]) {
					sum+= arr[i].jum;
					calsum += arr[i].cal;
				}
			}
			if(calsum>L) {
				return;
			}
			ans = Math.max(ans, sum);
			return;
		}
		sel[idx]=true;
		powerSet(idx+1,k+1,sel,arr);
		sel[idx]=false;
		powerSet(idx+1,k,sel,arr);
	}
}
