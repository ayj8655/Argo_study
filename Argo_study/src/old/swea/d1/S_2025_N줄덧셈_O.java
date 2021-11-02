package old.swea.d1;

import java.util.Scanner;

public class S_2025_N줄덧셈_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			Ans+=i;
		}
		System.out.println(Ans);
	}
}
