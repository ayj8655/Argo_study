package old.baekjoon.bronze;


import java.io.*;
import java.util.*;

public class B_10952_A더하기B_5 {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_10952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a==0 && b == 0) 
				break;
			
			sb.append(a+b + "\n");
		}
		
		
		System.out.print(sb);
		
		

	}

}
