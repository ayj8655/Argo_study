package study.greedy;

import java.io.*;
import java.util.*;

public class 큰수의법칙 {
	
	static int arr[];
	static int N,M,K,ans;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_큰수의법칙.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int temp = K;
		for (int i =0; i < M; i++) {
			
			temp = temp-1;
			if (temp != 0) {
				ans += arr[N-1];
			} 
			else {
				ans += arr[N-2];
				temp = K;
			}
			
		}
		
		
		System.out.println(ans);
		
		
		
	}

}
