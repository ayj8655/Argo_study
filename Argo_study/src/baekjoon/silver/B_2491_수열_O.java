package baekjoon.silver;

import java.util.Scanner;

public class B_2491_수열_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int arr[] = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] =sc.nextInt();
		}
		
		int sum=0;
		for (int i = 0; i < N; i++) {	//이건 큰거
			
			int first = arr[i];
			sum=1;
			for (int j = 1+i; j < arr.length; j++) {
				
				if (first <= arr[j]) {
					sum++;
					first = arr[j];
				}
				else break;
				
				
			}
			Ans = Math.max(Ans, sum);
			
		}
		for (int i = 0; i < N; i++) {
			
			int first = arr[i];
			sum=1;
			for (int j = 1+i; j < arr.length; j++) {
				
				if (first >= arr[j]) {
					sum++;
					first = arr[j];
				}
				else break;
			}
			Ans = Math.max(Ans, sum);
			
		}
		if(Ans==2) System.out.println(2);
		else if( Ans==1) System.out.println(1);	//1일때 1 안나오게 해서 100%에서 틀림 ㅡㅡ
		else System.out.println(Ans);
		
		
		
		
	}
}
