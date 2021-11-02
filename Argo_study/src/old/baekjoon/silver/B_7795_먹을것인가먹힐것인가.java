package old.baekjoon.silver;

import java.io.*;
import java.util.*;

public class B_7795_먹을것인가먹힐것인가 {
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_7795.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int A[] = new int [n];
			int B[] = new int [m];
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < n; i++) {
				A[i]= Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < m; i++) {
				B[i]= Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(A[i] > B[j]) 
						cnt++;
					else 
						break;
				}
			}
			sb.append(cnt).append("\n");
			
			
			
		}
		System.out.print(sb.toString());
		br.close();
	}

}
