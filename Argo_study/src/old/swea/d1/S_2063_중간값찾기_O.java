package old.swea.d1;

import java.util.Arrays;
import java.util.Scanner;

public class S_2063_중간값찾기_O {
	static int N,T,Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int [] arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i]= sc.nextInt();
		}
		Arrays.sort(arr);
		int n = T/2;
		System.out.println(arr[n]);
		
	}
}
