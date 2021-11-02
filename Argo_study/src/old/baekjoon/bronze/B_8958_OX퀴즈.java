package old.baekjoon.bronze;


import java.io.*;
import java.util.*;

public class B_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_8958.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		
		int count =1;
		int score = 0;
		
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			int length = str.length();
			count = 1;
			score = 0;
			
			for (int j = 0; j < length; j++) {
				if(str.charAt(j) == 'O') {
					score+=count;
					count++;
					
				}else
					count=1;
				
			}
			
			
			System.out.println(score);
		}
		

	}

}
