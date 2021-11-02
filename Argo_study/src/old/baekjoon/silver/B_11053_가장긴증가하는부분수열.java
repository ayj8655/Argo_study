package old.baekjoon.silver;

import java.util.*;
import java.io.*;

public class B_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int []arr = new int[N];
		int []LIS = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max=0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && LIS[i] < LIS[j]+1) {
					LIS[i]= LIS[j]+1;
				}
				
			}
			if(max<LIS[i]) max = LIS[i];
		}
		
	//	System.out.println(Arrays.toString(LIS));
		System.out.println(max);
	}

}
