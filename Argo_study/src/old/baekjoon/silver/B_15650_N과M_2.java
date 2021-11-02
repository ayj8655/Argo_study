package old.baekjoon.silver;

import java.util.*;
import java.io.*;

/*

 * 15650    N과 M (2) - 중복되지 않은 조합
 * 
 * 
15649    N과 M (1) - 중복되지 않은 순열
15651    N과 M (3) - 중복을 허용하는 순열
15652    N과 M (4) - 중복을 허용하는 조합
15654    N과 M (5) - 중복되지 않은 순열(사용자 입력)  
15655    N과 M (6) - 중복되지 않은 조합(사용자 입력) 
15656    N과 M (7) - 중복을 허용하는 순열(사용자 입력)
15657    N과 M (8) - 중복을 허용하는 조합(사용자 입력)
 * */

public class B_15650_N과M_2 {

	
	
	private static void combination(int[] arr, int[] sel, int idx, int k) {
		if(k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {		//idx를 i에 넣는게 핵심
			
			sel[k]= arr[i];
			combination(arr, sel, i+1, k+1);	//i+1로 중복허용안하는거 가능
			
		}
		
	}
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		combination(arr,new int[M],0,0);
		System.out.print(sb);

	}

}
