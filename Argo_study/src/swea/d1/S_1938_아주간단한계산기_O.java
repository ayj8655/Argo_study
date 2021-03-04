package swea.d1;

import java.util.Scanner;

public class S_1938_아주간단한계산기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		N = sc.nextInt();
		
		
		System.out.println(T+N);
		System.out.println(T-N);
		System.out.println(T*N);
		System.out.println(T/N);
		
	}
}
