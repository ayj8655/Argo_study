package old.swea.d1;

import java.util.Scanner;

public class S_2071_평균값구하기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			Ans=0;
			for (int i = 0; i < 10; i++) {
				Ans+=sc.nextInt();
			}
			
			System.out.printf("#%d %.0f\n", t, Ans/10.0);
		}
		
	}
}
