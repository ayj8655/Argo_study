package swea.d1;

import java.util.Scanner;

public class S_2029_몫과나머지출력하기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int a =sc.nextInt();
			int b = sc.nextInt();
			
			
			System.out.printf("#%d %d \n", a/b, a%b);
		}
		
	}
}
