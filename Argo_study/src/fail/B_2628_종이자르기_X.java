package fail;

import java.util.Scanner;

public class B_2628_종이자르기_X {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y =sc.nextInt();
		int x = sc.nextInt();
		T = sc.nextInt();
		int ta=0,tb=0;
		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a == 1) {
				
				if (b <tb ) continue;
				
				if (y - b > b) {
					y = y - b;
				}
				else {
					y = b;
				}
				tb = b;
				
			}
			else if (a==0) {
				if (b <ta ) continue;
				
				if (x - b > b) {
					x = x - b;
				}
				else {
					x = b;
				}
				ta = b;
			}
		}
		
		System.out.println(y*x);
		
		
		
	}
}
