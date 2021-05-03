package baekjoon.bronze;

import java.util.*;
import java.io.*;


public class B_2846_오르막길 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_2846.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0; // 오르막길마다 합
		int Ans = 0; // 최종 오르막길 최대값
		
		for(int i=0;i<N-1;i++) {
			
			if(arr[i]<arr[i+1]) 
				sum += (arr[i+1]-arr[i]);	//뒤가 더 크면 차이만큼 저장
			else 
				sum = 0;	//작거나 같으면 처음부터
			Ans = Math.max(Ans, sum);
		}
		
		System.out.println(Ans);
		
		
		
	}

}
