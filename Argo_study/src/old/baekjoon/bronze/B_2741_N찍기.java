package old.baekjoon.bronze;

import java.io.*;
import java.util.*;


public class B_2741_N찍기 {

	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_B_2741.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int temp = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= temp; i++) 
			sb.append(i+"\n");
		
		
		System.out.println(sb);
		

	}

}
