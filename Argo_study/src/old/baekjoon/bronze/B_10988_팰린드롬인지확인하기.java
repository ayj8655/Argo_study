package old.baekjoon.bronze;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10988
 * 팰린드롬인지 확인하기
 * 
 * 
 * */
public class B_10988_팰린드롬인지확인하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		
		int length = st.length();
		char[] ar = new char[length];
		
		for (int i = 0; i < length; i++) {
			ar[i] = st.charAt(i);
		}
		boolean flag = true;
		int even = length/2;
		length = length-1;
	
        for (int i = 0; i < even; i++) {
            if (!(ar[i] == ar[length])) {
                flag = false;
            }
            length--;
        }
		
		
		if(flag == true) System.out.println("1");
		else System.out.println("0");
	}
}