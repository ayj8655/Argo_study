package swea.d1;

import java.util.Scanner;

public class S_2070_큰놈작은놈같은놈_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		char ch = 0;
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a<b) ch='<';
			else if (a>b) ch='>';
			else ch='=';
			
			System.out.printf("#%d %s\n", t, ch);
		}
		
	}
}
