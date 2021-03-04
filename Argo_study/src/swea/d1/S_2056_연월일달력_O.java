package swea.d1;

import java.util.Scanner;

public class S_2056_연월일달력_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		int daysOfMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31}; 
		
		for(int t = 1; t <= T; t++) {
            String s = sc.next();
            String result = "-1";
            
            int month = Integer.valueOf(s.substring(4,6));
            int day = Integer.valueOf(s.substring(6,8));
            
            if( 1<=month && month<=12 && 1<=day && day<=daysOfMonth[month-1] ) {
                result = String.format("%s/%s/%s", s.substring(0,4), s.substring(4,6), s.substring(6,8));
            }
            
            System.out.format("#%d %s\n", t, result);
		}
		
	}
}
