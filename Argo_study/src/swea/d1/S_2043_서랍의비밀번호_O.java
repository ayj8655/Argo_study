package swea.d1;

import java.util.Scanner;

public class S_2043_서랍의비밀번호_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		N = sc.nextInt();
		
		for (int i = N; i <= T; i++) {
			Ans++;
		}
		System.out.println(Ans);
		
	}
}
