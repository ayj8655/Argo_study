package swea.d1;

import java.util.Scanner;

public class S_2019_더블더블_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int a=1;
		for (int i = 0; i <= T; i++) {
			
			System.out.print(a+" ");
			a *=2;
		}
		
	}
}
