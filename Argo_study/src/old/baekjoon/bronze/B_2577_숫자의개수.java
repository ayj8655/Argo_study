package old.baekjoon.bronze;

import java.util.*;
import java.io.*;

public class B_2577_숫자의개수 {

	
	static int arr[];
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_2577.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		arr = new int[10];
		int temp = 1;
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine()," ");
			temp *= Integer.parseInt(st.nextToken());	
		}
		
		String str = String.valueOf(temp);
		int length = str.length();
		
		
		
		for (int i = 0; i < length; i++) 
			arr[str.charAt(i) - 48]++;
		
		
		for (int i = 0; i < 10; i++) 
			System.out.println(arr[i]);
		
		
		
	
		
	}

}
