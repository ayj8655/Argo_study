package bakejoon.bronze;

import java.io.*;
import java.util.*;

public class B_8958_OX퀴즈 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
				
		N = Integer.parseInt(br.readLine());
		
		for(int i =0; i < N; i++) {
			String str = br.readLine();
			int length = str.length();			
			int cnt=0;
			int result =0;
			for (int j = 0; j < length; j++) {
				
				if (str.charAt(j) == 'O') {
					cnt++;
					result += cnt;
				} else {
					
					cnt = 0;
				}
			}
			
			System.out.println(result);
		}
		
	}

}
