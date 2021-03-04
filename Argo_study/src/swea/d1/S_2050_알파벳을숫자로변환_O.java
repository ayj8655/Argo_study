package swea.d1;

import java.util.Scanner;

public class S_2050_알파벳을숫자로변환_O {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		for (int i=0; i<str.length();i++){
			int num = (int) str.charAt(i);	//문자열에서 인자로 주어진 값에 해당하는 문자를 리턴한다.
			System.out.format("%d ", num-64);
		}

		
	}
}
