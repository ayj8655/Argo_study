package swea.d2;

import java.util.Scanner;

public class S_2005_파스칼의삼각형_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			System.out.printf("#%d\n", t);
			
			int i, j;
            int A[] = new int[N+2];
            int B[] = new int[N+2];
            A[1] = 1;
            for(i=1; i<=N; i++) {
                
                for(j=1; j<i+1; j++) {
                	System.out.format("%d ", A[j]);
                }
                System.out.println();
                
                for(j=1; j<i+2; j++) {
                	B[j] = A[j-1]+A[j];
                }
                
                for(j=1; j<i+2; j++) {
                	A[j] = B[j];
                }
            }
			
		}
		
	}
}
