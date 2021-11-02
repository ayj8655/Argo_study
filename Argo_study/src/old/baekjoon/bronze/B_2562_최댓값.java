package old.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class B_2562_최댓값 {

	static int arr[];
	static int Ans;
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("res/input_B_2562.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int [9];
		
		for (int i = 0; i < 9; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < 9; i++) {
			if(arr[i]> max) {
				max = arr[i];
				index = i;
			}
		}
		
		
		System.out.println(max);
		System.out.println(index+1);
		
		
		
		
		
	
	}
}