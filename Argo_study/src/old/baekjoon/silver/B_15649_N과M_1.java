package old.baekjoon.silver;


import java.io.*;

import java.util.*;

/*
 * 15649    N과 M (1) - 중복되지 않은 순열
 * 
 * 
15650    N과 M (2) - 중복되지 않은 조합
15651    N과 M (3) - 중복을 허용하는 순열
15652    N과 M (4) - 중복을 허용하는 조합
15654    N과 M (5) - 중복되지 않은 순열(사용자 입력)  
15655    N과 M (6) - 중복되지 않은 조합(사용자 입력) 
15656    N과 M (7) - 중복을 허용하는 순열(사용자 입력)
15657    N과 M (8) - 중복을 허용하는 조합(사용자 입력)
 * */


public class B_15649_N과M_1 {


	private static void permutation(int[] arr, int[] sel, int k, boolean[] v) {
		
		if(k==sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]+" ");
				
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			
			if(v[i]==false) {
				v[i] = true;
				sel[k] = arr[i];
				permutation(arr, sel, k+1,v);
				v[i] = false;		
				
			}	
		}
	}
	
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		permutation(arr,new int[M],0,new boolean[arr.length]);
		System.out.print(sb);
		
	}

}

