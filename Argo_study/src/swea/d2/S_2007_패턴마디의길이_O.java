package swea.d2;

import java.util.Scanner;



//문자열을 서브스트링으로 나누고 나머지를 또 나눈다. 이후 두개가 같은지 비교해서 같으면 그 i값이 동일한 패턴

public class S_2007_패턴마디의길이_O{
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			String s = sc.next();
			Ans = 0;
			
			for(int i=1; i<10; i++) {
				
			    String sub = s.substring(0,i);
			    String subNext = s.substring(i,i+i);
			    
			    if( sub.equals(subNext) ) {
			    	Ans = i;
			        break;
			    }
			}
			
			System.out.printf("#%d %d\n", t, Ans);
		}
		
	}
}
