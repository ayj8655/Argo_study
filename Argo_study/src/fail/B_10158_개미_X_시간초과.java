package fail;

import java.util.Scanner;

public class B_10158_개미_X_시간초과 {
	static int W,H,P,Q,T;
	
	static int dx[] = {1,-1,-1};
	static int dy[] = {1,1,-1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		P = sc.nextInt();
		Q = sc.nextInt();
		T = sc.nextInt();
		int dd=0;
		int p=P;
		int q=Q;
		for (int i = 0; i < T; i++) {
			
			p = p + dx[dd];
			q = q + dy[dd];
			if(p == W ) {
				dd=1;
			} else if (q == H) {
				dd=2;
			}
			else if(p==0) {
				dd=0;
			}
			else if(q==0) {
				dd=1;
			}
			
			
		}
		
		System.out.println(p+" "+ q);
		
		
		
		
	}
}
