package bakejoon.bronze;

import java.io.*;
import java.util.*;

public class B_4344_평균은넘겠지 {
	
	static double arr[];
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			
			arr = new double[M];
			
			double avg =0;
			for (int j = 0; j < M; j++) {
				arr[j] = Double.parseDouble(st.nextToken());
				avg += arr[j];
			}
			
			avg = avg/M;
			
			int cnt =0;
			for (int j = 0; j < M; j++) {
				if(arr[j] > avg) {
					cnt++;
				}
			}
			double result = ((double)cnt/M) *100;
			System.out.print(String.format("%.3f",result));
			System.out.println("%");
			
			
			
			
			
			
		}
		
		
	}

}
