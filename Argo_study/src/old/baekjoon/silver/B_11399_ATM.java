package old.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 
 * https://www.acmicpc.net/problem/11399
 * ATM
 * 
 * 
 * 
 * */
public class B_11399_ATM {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0,ans=0;
		int[] arr = new int[N];
		int[] result = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 3 3+1 3+1+4 3+1+4+3 3+1+4+3+2
		//그냥 정렬하고 순서대로 쭉 더하면 그게 정답?
		//+0 -> +0+1
		Arrays.sort(arr);
	
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			result[i] = sum;
		}
		
		for (int i = 0; i < result.length; i++) {
			ans += result[i];
		}
		
		
		
		System.out.println(ans);
	}
}
