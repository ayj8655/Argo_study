package swea.d1;

import java.util.Scanner;

public class S_2072_홀수만더하기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			Ans=0;
			for (int i = 0; i < 10; i++) {
				int a = sc.nextInt();
				if (a%2!=0) Ans+=a;
			}
			
			System.out.printf("#%d %d\n", t, Ans);
		}
		
	}
}
