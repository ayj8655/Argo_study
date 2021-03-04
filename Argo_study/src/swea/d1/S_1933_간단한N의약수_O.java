package swea.d1;

import java.util.Scanner;

public class S_1933_간단한N의약수_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			if(T%i == 0) System.out.print(i+" ");
		}
		
	}
}
