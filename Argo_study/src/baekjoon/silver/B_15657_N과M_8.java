package baekjoon.silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/*

15657    N과 M (8) - 중복을 허용하는 조합(사용자 입력)
* 
* 
15649    N과 M (1) - 중복되지 않은 순열
15650    N과 M (2) - 중복되지 않은 조합
15651    N과 M (3) - 중복을 허용하는 순열
15652    N과 M (4) - 중복을 허용하는 조합
15654    N과 M (5) - 중복되지 않은 순열(사용자 입력)
15655    N과 M (6) - 중복되지 않은 조합(사용자 입력)
15656    N과 M (7) - 중복을 허용하는 순열(사용자 입력)
* */


public class B_15657_N과M_8 {
static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		combination(arr, new int[M], 0, 0);
		bw.flush();
		
		
	}

	private static void combination(int[] arr, int[] sel, int idx, int k) throws IOException {
		if(k == sel.length) {
			
			for (int i = 0; i < sel.length; i++) {
				bw.write(sel[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {		//idx를 i에 넣는게 핵심
			
			sel[k]= arr[i];
			combination(arr, sel, i, k+1);
			
		}
		
	}
}
