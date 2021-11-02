package old.swea.d1;

import java.util.Scanner;

public class S_1545_거꾸로출력해보아요_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int i = T; i >= 0; i--) {
			System.out.print(i+" ");
		}
		
	}
}
