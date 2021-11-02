package old.swea.d1;

import java.util.Scanner;

public class S_2027_대각선출력하기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 5;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) System.out.print("#");
				else System.out.print("+");
			}
			System.out.println();
		}
		
	}
}
