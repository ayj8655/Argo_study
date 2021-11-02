package old.baekjoon.bronze;

import java.util.*;
import java.io.*;

public class B_2750_수정렬하기 {
	
	static int N;
	static int arr[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_2750.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());	
		
		arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());	
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	

}
