package fail;

import java.util.LinkedList;
import java.util.Scanner;

public class B_2635_수이어가기_X {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		LinkedList <Integer> q = new LinkedList<>();
		
		
		for (int i = N; i >= N/2; i--) {
			LinkedList <Integer> q2 = new LinkedList<>();
			
			q2.add(N);
			int n =N;
			int number = i;
			
			while (true) {
				int second =n;
				if(number >=0) q2.add(number);
				
				
				
				
			}
			
			
		}
		
	}
}
