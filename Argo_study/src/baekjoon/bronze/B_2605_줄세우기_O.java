package baekjoon.bronze;

import java.util.LinkedList;
import java.util.Scanner;

//브론즈 2
public class B_2605_줄세우기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		q.add(0);
		

		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			q.add(i-num,i);
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(q.get(i)+" ");
			 
		}
		
		
	}
}
