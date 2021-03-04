package swea.d2;

import java.util.Scanner;

public class S_1926_간단한369게임_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			String s = Integer.toString(i);
			
			if(s.contains("3") || s.contains("6") || s.contains("9")) {
				s = s.replace("3", "-");
				s = s.replace("6", "-");
				s = s.replace("9", "-");
				s = s.replace("0", "");
				s = s.replace("1", "");
				s = s.replace("2", "");
				s = s.replace("4", "");
				s = s.replace("5", "");
				s = s.replace("7", "");
				s = s.replace("8", "");
			}
			
			
			System.out.print(s+" ");
			
		}
		
	
	}
}
