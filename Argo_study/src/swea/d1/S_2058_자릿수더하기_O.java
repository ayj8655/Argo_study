package swea.d1;

import java.util.Scanner;

public class S_2058_자릿수더하기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
        int sum = 0,a=0;
        for(int i=0; i<4; i++) {
         	a = T%10;
            T = T/10;
            sum += a;
        }
        System.out.print(sum);	
			
		
	}
}
