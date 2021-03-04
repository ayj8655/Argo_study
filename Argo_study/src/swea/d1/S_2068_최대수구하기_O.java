package swea.d1;

import java.util.Scanner;

public class S_2068_최대수구하기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			Ans=0;
			
			for (int i = 0; i < 10; i++) {
				int a = sc.nextInt();
				Ans = Math.max(Ans, a);
			}
			
			System.out.printf("#%d %d\n", t, Ans);
		}
		
	}
}
