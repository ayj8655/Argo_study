package baekjoon.silver;

import java.io.*;
import java.util.*;

/*

 * 15651    N과 M (3) - 중복을 허용하는 순열
 * 
 * 
15649    N과 M (1) - 중복되지 않은 순열
15650    N과 M (2) - 중복되지 않은 조합
15652    N과 M (4) - 중복을 허용하는 조합
15654    N과 M (5) - 중복되지 않은 순열(사용자 입력)  
15655    N과 M (6) - 중복되지 않은 조합(사용자 입력) 
15656    N과 M (7) - 중복을 허용하는 순열(사용자 입력)
15657    N과 M (8) - 중복을 허용하는 조합(사용자 입력)
 * */

//시간초과로 인해서 버퍼라이터 씀


public class B_15651_N과M_3 {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static void purmutation(int[] arr, int[] sel, int k) throws IOException {	//3의2승 =9번
		if(k==sel.length) {//다 고름
			for (int i = 0; i < sel.length; i++) {
				bw.write(sel[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			sel[k]=arr[i];
			purmutation(arr, sel, k+1);
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		purmutation(arr,new int[M],0);
		bw.flush();
		
	}

}
