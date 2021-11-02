package old.baekjoon.bronze;

import java.util.*;
import java.io.*;

public class B_2908_상수 {
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		//스트링 빌더에 reverse 메소드가 존재한다.
		
		StringBuilder sb = new StringBuilder();
		sb.append(st.nextToken()).reverse();
		int A = Integer.parseInt(sb.toString());
		
		sb = new StringBuilder();
		sb.append(st.nextToken()).reverse();
		int B = Integer.parseInt(sb.toString());
		
		
		
		System.out.print(A > B ? A:B);
		
	}
}
