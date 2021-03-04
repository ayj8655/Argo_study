package baekjoon.silver;

import java.util.Scanner;

public class B_2527_직사각형_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int i = 0; i < 4; i++) {
			int x,y,p,q,xx,yy,pp,qq;
			x =sc.nextInt();
			y =sc.nextInt();
			p =sc.nextInt();
			q =sc.nextInt();
			xx =sc.nextInt();
			yy =sc.nextInt();
			pp =sc.nextInt();
			qq =sc.nextInt();
			
			//공통부분이 없는 기준
			
			/*
			첫 직사각형의 x2보다 두번째 직사각형의 x1값이 큰 경우
			첫 직사각형의 x1이 두번째 직사각형의 x2값보다 큰 경우
			첫 직사각형의 y2보다 두번째 직사각형의 y1값이 큰 경우
			첫 직사각형의 y1이 두번째 직사각형의 y2값보다 큰 경우
			 */
			if ((p == xx && q == yy) || (x == pp && q == yy) || (p == xx && y == qq) || (x == pp && y == qq)) {
	           System.out.println("c");
	        } else if ((p == xx && q != yy) || (x == pp && q != yy) || (p != xx && y == qq) || (x != pp && y == qq)) {
	        	System.out.println("b");
	        } else if (p < xx || pp < x || q < yy || qq < y) {
	        	System.out.println("d");
	        } else {
	        	System.out.println("a");
	        }
			
		}
		
		
	}
}
