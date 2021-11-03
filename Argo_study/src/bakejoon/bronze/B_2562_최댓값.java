package bakejoon.bronze;

import java.io.*;
import java.util.*;

public class B_2562_최댓값 {
	
	static int arr[];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		arr = new int[9];
		
		for (int i=0; i< 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int max = Integer.MIN_VALUE, idx = 0;
		for (int i=0; i< 9; i++) {
			if (max < arr[i]) {
				max = arr[i];
				idx = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
		
	}

}
